/**
 * 
 */
package robo.io;

/**
 * Handles the output for robot on Standard console.
 * 
 * @author Raghwendra
 *
 */
public class StdOutputHandlerImpl implements OutputHandler {

	@Override
	public void printOutput(String msg) {
		/**
		 * prints the output for the robot
		 * 
		 * @param msg
		 */
		System.out.println(msg);
	}

}
