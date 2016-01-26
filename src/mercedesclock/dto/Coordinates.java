package mercedesclock.dto;

/**
 * A Coordinates DTO - a wrapper for x- and y-coordinates
 */
public class Coordinates {
	private double xCoord;
	private double yCoord;
	
	/**
	 * Constructor - wraps x-coordinate and y-coordinate in this DTO
	 * @param xCoord of type double
	 * @param yCoord of type double
	 */
	public Coordinates(double xCoord, double yCoord){
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	/**
	 * This method returns x-coordinate
	 * @return xCoord of type double
	 */
	public double getXCoord() {
		return xCoord;
	}
	
	/**
	 * This method returns y-coordinate
	 * @return yCoord of type double
	 */
	public double getYCoord() {
		return yCoord;
	}
}