/**
 * 
 */
package robo.io;

import java.util.Scanner;

/**
 * Handles the input commands for robot from Standard input stream.
 * 
 * @author Raghwendra
 *
 */
public class StdInputHandlerImpl implements InputHandler {

	private static Scanner sc = new Scanner(System.in, "UTF-8");

	/**
	 * Reads and returns the input command for robot.
	 * 
	 * @return input command
	 */
	@Override
	public String readInput() {
		return sc.nextLine();
	}

	/**
	 * Closes input stream
	 */
	@Override
	public void close() {
		sc.close();
	}

}
