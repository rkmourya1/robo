/**
 * 
 */
package robo.bean;

/**
 * This class defines the robots positions and its functions.
 * 
 * @author Raghwendra
 *
 */
public class Robot {
	// Table Boundary
	public static final int EASTEND = 5;
	public static final int WESTEND = 0;
	public static final int NORTHEND = 5;
	public static final int SOUTHEND = 0;

	// Robo Face Directions
	private static final int EAST = 0;
	private static final int NORTH = 1;
	private static final int WEST = 2;
	private static final int SOUTH = 3;

	// Robo transient positions
	private int positionX = -1; // WESTEND <-> EASTEND
	private int positionY = -1; // NORTHEND <-> SOUTHEND
	private int facePosition = -1; // EAST=0, NORTH=1, WEST=2, SOUTH=3

	/**
	 * This method sets the position of the robot on the table for the given input
	 * parameters. If the given parameters are not valid or does not belongs on the
	 * table, then it will ignore to set the position.
	 * 
	 * @param positionX    -
	 * @param positionY
	 * @param facePosition - EAST, WEST, NORTH or SOUTH
	 */
	public void setPosition(int positionX, int positionY, String facePosition) {
		int faceInt = -1;
		if ("EAST".equalsIgnoreCase(facePosition)) {
			faceInt = EAST;
		} else if ("NORTH".equalsIgnoreCase(facePosition)) {
			faceInt = NORTH;
		} else if ("WEST".equalsIgnoreCase(facePosition)) {
			faceInt = WEST;
		} else if ("SOUTH".equalsIgnoreCase(facePosition)) {
			faceInt = SOUTH;
		}

		setPosition(positionX, positionY, faceInt);
	}

	/**
	 * This method sets the position of the robot on the table for the given input
	 * parameters. If the given parameters are not valid or does not belongs on the
	 * table, then it will ignore to set the position.
	 * 
	 * @param positionX    -
	 * @param positionY
	 * @param facePosition - Integer value for EAST, WEST, NORTH or SOUTH
	 */
	private void setPosition(int positionX, int positionY, int facePosition) {
		if (isValidPosition(positionX, positionY, facePosition)) {
			this.positionX = positionX;
			this.positionY = positionY;
			this.facePosition = facePosition;
		}
	}

	/**
	 * Checks input values represents right position on table.
	 * 
	 * @param xVal
	 * @param yVal
	 * @param faceVal
	 * @return true if the input values represents right position on table, else
	 *         returns false.
	 */
	public boolean isValidPosition(int xVal, int yVal, int faceVal) {
		if (xVal < WESTEND || xVal > EASTEND) {
			return false;
		}
		if (yVal < SOUTHEND || yVal > NORTHEND) {
			return false;
		}
		if (!(faceVal == EAST || faceVal == NORTH || faceVal == WEST || faceVal == SOUTH)) {
			return false;
		}
		return true;
	}

	/**
	 * This method moves robot position front by one unit within table range. If
	 * hits boundary, it will ignore the move.
	 */
	public void move() {
		if (facePosition == NORTH && positionY < NORTHEND) {
			positionY += 1;
		} else if (facePosition == SOUTH && positionY > SOUTHEND) {
			positionY -= 1;
		} else if (facePosition == EAST && positionX < EASTEND) {
			positionX += 1;
		} else if (facePosition == WEST && positionX > WESTEND) {
			positionX -= 1;
		} // else ignore the wrong move.
	}

	/**
	 * Turns robot face position to left.
	 */
	public void turnLeft() {
		facePosition = (facePosition == SOUTH) ? EAST : facePosition + 1;
	}

	/**
	 * Turns robot face position to right.
	 */
	public void turnRight() {
		facePosition = (facePosition == EAST) ? SOUTH : facePosition - 1;
	}

	/**
	 * @return String name of Face Position
	 */
	private String getFacePositionName() {
		if (facePosition == EAST)
			return "EAST";
		if (facePosition == NORTH)
			return "NORTH";
		if (facePosition == WEST)
			return "WEST";
		if (facePosition == SOUTH)
			return "SOUTH";
		return null;
	}

	/**
	 * Checks if Current Position of robot is set with correct values on the table.
	 * 
	 * @return true if position is set on table.
	 */
	public boolean isRoboPlaced() {
		// Check if current Position is set with correct values
		return isValidPosition(positionX, positionY, facePosition);
	}

	/**
	 * @return current position of robot.
	 */
	public String getRoboPosition() {
		return "" + positionX + "," + positionY + "," + getFacePositionName();
	}

}
