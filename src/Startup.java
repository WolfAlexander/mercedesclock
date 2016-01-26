import mercedesclock.contoller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * The mercedes clock starting class
 * @author Alexander
 */
public class Startup extends Application{
	private static Controller contr;
	/**
	 * Construct View and Controller object
	 * @param args
	 */
	public static void main(String[] args){
		contr = new Controller();
		launch(args);
	}
	
	/**
	 * This method is the start method for JavaFX
	 * Start first scene and shows GUI window
	 * @param primary stage of type Stage is the window of program
	 */
	public void start(Stage prmStage) throws Exception{
		contr.setPrimaryStage(prmStage);
		contr.startClock();
		prmStage.initStyle(StageStyle.UNDECORATED);
		prmStage.initStyle(StageStyle.TRANSPARENT);
		prmStage.show();
	}
}