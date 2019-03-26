
package robo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import robo.bean.Robot;
import robo.io.InputHandler;
import robo.io.OutputHandler;
import robo.io.StdInputHandlerImpl;
import robo.io.StdOutputHandlerImpl;

/**
 * This is a Robo App, which takes the command; and places, moves, turns and
 * reports the robot position on a table of 5 by 5 unit.
 * 
 * @author Raghwendra
 *
 */
public class MyRoboApp {
	// Robot with its position
	private Robot robo = new Robot();

	// Robot Input Command stream handler
	private InputHandler inHandler;
	// Robot Output stream handler
	private OutputHandler outHandler;

	public MyRoboApp() {
		inHandler = new StdInputHandlerImpl();
		outHandler = new StdOutputHandlerImpl();
	}

	public MyRoboApp(InputHandler inHandler, OutputHandler outHandler) {
		this.inHandler = inHandler;
		this.outHandler = outHandler;
	}

	/**
	 * Start to play with robot by giving correct commands via InputHandler.
	 */
	public void play() {
		outHandler.printOutput("Welcome to play with MyRobo. Please enter commands to play with it.");
		outHandler.printOutput(
				"Enter Command 'PLACE <0-5>,<0-5>,EAST|NORTH|WEST|SOUTH', to place the robo on the square table between points (0,0) and (5,5) with face direction.");
		outHandler.printOutput("Then enter command LEFT|RIGHT|REPORT, to play with robo.");
		outHandler.printOutput(
				"Then enter command REPORT, reports location of robo on table and face direction, if placed in table");
		outHandler.printOutput("Enter command EXIT, to exit the game.");
		outHandler.printOutput("");
		boolean isContd = true;
		while (isContd) {
			outHandler.printOutput("Enter command [PLACE X,Y,F|MOVE|LEFT|RIGHT|REPORT|EXIT]: ");
			String command = inHandler.readInput();
			isContd = executeCommand(command);
		}
	}

	/**
	 * Executes the command to the robot.
	 * 
	 * @param command
	 * @return
	 */
	private boolean executeCommand(String command) {
		if (robo.isRoboPlaced()) { // MOVE|LEFT|RIGHT|REPORT only valid once robo is placed.
			if ("MOVE".equalsIgnoreCase(command)) {
				robo.move();
				return true;
			} else if ("LEFT".equalsIgnoreCase(command)) {
				robo.turnLeft();
				return true;
			} else if ("RIGHT".equalsIgnoreCase(command)) {
				robo.turnRight();
				return true;
			} else if ("REPORT".equalsIgnoreCase(command)) {
				reportLocation(robo.getRoboPosition());
				return true;
			}
		}
		if ("EXIT".equalsIgnoreCase(command)) {
			outHandler.printOutput("Thank you for playing with Robo. Exiting now, bye!");
			return false;
		}
		// Check for, PLACE command
		place(command);
		return true;
	}

	/**
	 * Executes place command for the robot. Reads and parses the place values and
	 * sets to robots
	 * 
	 * @param cmd
	 */
	private boolean place(String cmd) {
		Pattern pattern = Pattern.compile("PLACE\\s+([" + Robot.WESTEND + "-" + Robot.EASTEND + "]),([" + Robot.SOUTHEND
				+ "-" + Robot.NORTHEND + "]),(EAST|NORTH|WEST|SOUTH)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(cmd);
		if (matcher.find()) { // Matches PLACE
			setPlace(matcher.group(1), matcher.group(2), matcher.group(3));
		}
		if (!robo.isRoboPlaced()) {
			outHandler.printOutput(
					"WARNING: Robo is not placed in Table yet, please use correct place command first to play.");
			return false;
		}
		return true;
	}

	/**
	 * Sets the place values for the robots.
	 * 
	 * @param xStr
	 * @param yStr
	 * @param faceStr
	 */
	private void setPlace(String xStr, String yStr, String faceStr) {
		int xVal;
		int yVal;
		try {
			xVal = Integer.parseInt(xStr);
			yVal = Integer.parseInt(yStr);
		} catch (NumberFormatException nfe) {
			return;
		}
		robo.setPosition(xVal, yVal, faceStr);
	}

	/**
	 * reports location of robot to output stream.
	 * 
	 * @param position
	 */
	private void reportLocation(String position) {
		outHandler.printOutput("Output: " + position);
	}

	@Override
	protected void finalize() throws Throwable {
		inHandler.close();
		super.finalize();
	}

	public static void main(String... strings) {
		MyRoboApp robo = new MyRoboApp();
		robo.play();
	}

}
