package mercedesclock.model;

import java.util.Calendar;
import mercedesclock.dto.Coordinates;
import javafx.scene.input.MouseEvent;

/**
 * Clock object takes care of clock functions 
 * @author Alexander
 *
 */
public class Clock {
	private Calendar calendar = Calendar.getInstance();
	private static double xCoord;
	private static double yCoord;
	
	/**
	 * This method saves position of it when it is pressed
	 * @param e - mouse event
	 */
	public void clockOnPressed(MouseEvent e){
		xCoord = e.getSceneX();
		yCoord = e.getSceneY();
	}
	
	/**
	 * This method moves clock on the screen
	 * @param prmStage - the primary stage
	 * @param e - mouse event
	 */
	public Coordinates moveClock(MouseEvent e){
		return new Coordinates(e.getScreenX() - xCoord, e.getScreenY() - yCoord);
	}
	
	/**
	 * Returns current value of seconds
	 * @return current seconds value of type int
	 */
	public double getSeconds(){
		return calendar.get(Calendar.SECOND);
	}
	
	/**
	 * Returns current value of minutes
	 * @return current minutes value of type int
	 */
	public double getMinutes(){
		return calendar.get(Calendar.MINUTE);
	}
	
	/**
	 * Returns current value of hours
	 * @return current hours value of type int
	 */
	public double getHours(){
		return calendar.get(Calendar.HOUR);
	}	
}