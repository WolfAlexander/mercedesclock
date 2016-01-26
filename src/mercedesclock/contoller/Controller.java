package mercedesclock.contoller;

import mercedesclock.dto.Coordinates;
import mercedesclock.model.Clock;
import mercedesclock.view.View;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {
	private Stage prmStage = null;
	private Clock clock;

	/**
	 * This methods sets reference to primary stage of the program
	 * to a field in controller and creates new clock
	 */
	public void setPrimaryStage(Stage prmStage){
		this.prmStage = prmStage;
	}
	
	/**
	 * This method creates clock 
	 */
	public void startClock(){
		clock = new Clock();
		startView();
	}
	
	
	private void startView(){
		new View(prmStage, this);
	}
	
	/**
	 * This method closes application
	 */
	public void closeApplication(){
		prmStage.close();
	}
	
	/**
	 * This method minimizes application
	 */
	public void minimizeApplication(){
		prmStage.setIconified(true);
	}
	
	/**
	 * This method takes position of the scene when mouse is pressed on in
	 */
	public void mouseOnPressed(MouseEvent e){
		clock.clockOnPressed(e);
	}
	
	/**
	 * This method sets new coordinates of the scene when it is moved
	 */
	public Coordinates mouseOnDragged(MouseEvent e){
		return clock.moveClock(e);
	}
	
	/**
	 * This methods gets current second
	 * @return seconds of type int
	 */
	public double getCurrentSeconds(){
		return clock.getSeconds();
	}
	
	/**
	 * This method gets current minuter
	 * @return minutes of type int
	 */
	public double getCurrentMinutes(){
		return clock.getMinutes();
	}
	
	/**
	 * This method gets current hours
	 * @return hours if type int
	 */
	public double getCurrentHours(){
		return clock.getHours();
	}
}
