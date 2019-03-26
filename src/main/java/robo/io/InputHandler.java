/**
 * 
 */
package robo.io;

/**
 * Handles the input commands for robot.
 * 
 * @author Raghwendra
 *
 */
public interface InputHandler {
	/**
	 * Reads and returns the input command for robot.
	 * 
	 * @return input command
	 */
	public String readInput();

	/**
	 * Closes input stream
	 */
	public void close();
}
