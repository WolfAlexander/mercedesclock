package mercedesclock.view;

import mercedesclock.contoller.Controller;
import mercedesclock.dto.Coordinates;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class View{
	private final int SCENE_WIDTH = 250;
	private final int SCENE_HEIGHT = 270;
	private Stage prmStage;
	private Controller contr;
	private BorderPane layout;
	
	/**
	 * The view constructor - creates all parts and sets scene
	 * @param prmStage
	 */
	public View(Stage prmStage, Controller contr){
		this.contr = contr;
		this.prmStage = prmStage;
		
		setLayout();
		createControlls();
		createClock();
		createAndSetScene();
	}
	
	private void setLayout(){
		layout = new BorderPane();
		layout.setStyle("-fx-background-color: rgba(0,0,0,0)");
		
		layout.setOnMousePressed(e-> contr.mouseOnPressed(e));
		layout.setOnMouseDragged(e-> {
			Coordinates newCoords = contr.mouseOnDragged(e);
			prmStage.setX(newCoords.getXCoord());
			prmStage.setY(newCoords.getYCoord());
			
		});
	}
	
	private void createControlls(){
		HBox topNav = new HBox();
		topNav.setId("topNav");
		
		Button closeBttn = new Button("x");
		closeBttn.setOnAction(e->{
			contr.closeApplication();
		});
		
		Button minimizeBttn = new Button("_");
		minimizeBttn.setOnAction(e->{
			contr.minimizeApplication();
		});
		
		topNav.getChildren().addAll(minimizeBttn, closeBttn);
		layout.setTop(topNav);
	}
	
	private void createClock(){
		Pane clock = new Pane();
		clock.setId("clock");
		
		createClockNumbers(clock);
		createTicks(clock);
		createClockHands(clock);
		
		layout.setCenter(clock);
	}
	
	private void createClockNumbers(Pane clock){
		for(int i = 1; i <= 12; i++){
			Label number = new Label(Integer.toString(i));
			
			number.getTransforms().add(new Rotate(i*30-2));
			number.getTransforms().add(new Translate(0, -110));
			
			number.setTranslateX(125);
			number.setTranslateY(125);
			
			clock.getChildren().add(number);
		}
	}
	
	private void createTicks(Pane clock){
		for(int i = 0; i < 60; i++){
			Line tick = new Line(0, 0, 0, -5);
			tick.getStyleClass().add("tick");
			
			tick.getTransforms().add(new Rotate(i*6));
			tick.getTransforms().add(new Translate(0, -110));
			
			clock.getChildren().add(tick);
		}
	}
	
	private void createClockHands(Pane clock){
		Line secHand = new Line(0, 0, 0, -95);
		secHand.setId("secHand");
		double startSecValue = contr.getCurrentSeconds() * 6;
		startAnimation(secHand, Duration.seconds(60), startSecValue);
		
		Line minHand = new Line(0, 0, 0, -85);
		minHand.setId("minHand");
		double startMinValue = (contr.getCurrentMinutes() + contr.getCurrentSeconds() / 360) * 6;
		startAnimation(minHand, Duration.minutes(60), startMinValue);
		
		Line hourHand = new Line(0, 0, 0, -65);
		hourHand.setId("hourHand");
		double startHourValue = (contr.getCurrentHours() + contr.getCurrentMinutes() / 360 * 6) * 30;
		startAnimation(hourHand, Duration.hours(12), startHourValue);
		
		Circle handsNode = new Circle(5);
		handsNode.setId("handsNode");
		
		clock.getChildren().addAll(hourHand, minHand, secHand, handsNode);
	}
	
	private void startAnimation(Line line, Duration duration, double startValue){
		final Rotate rotation = new Rotate(startValue);
		line.getTransforms().add(rotation);
		
		final Timeline timeLine = new Timeline(
			new KeyFrame(
				duration,
				new KeyValue(
					rotation.angleProperty(),
					360 + startValue,
					Interpolator.LINEAR
				)
			)
		);
		
		timeLine.setCycleCount(Animation.INDEFINITE);
		timeLine.play();
	}
	
	private void createAndSetScene(){
		Scene scene = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT);
		scene.setFill(Color.TRANSPARENT);
		scene.getStylesheets().add("mercedesclock/view/main_style.css");
		prmStage.setScene(scene);
	}
}