package robo;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import robo.io.InputHandler;
import robo.io.OutputHandler;

/**
 * Test cases for testing MyRoboApp
 * 
 * @author Raghwendra
 *
 */
public class MyRoboAppTest {

	@Mock
	InputHandler inHandler;
	@Mock
	OutputHandler outHandler;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test place robot
	 */
	@Test
	public void testPlayCase1() {

		MyRoboApp robo = new MyRoboApp(inHandler, outHandler);
		doReturn("PLACE 0,1,EAST", "REPORT", "EXIT").when(inHandler).readInput();
		// when(sRobo.readInput()).thenReturn("PLACE
		// 0,1,EAST").thenReturn("REPORT").thenReturn("EXIT");
		robo.play();
		verify(outHandler).printOutput("Output: 0,1,EAST");
	}

	/**
	 * Test place and move
	 */
	@Test
	public void testPlayCase2() {
		MyRoboApp robo = new MyRoboApp(inHandler, outHandler);
		doReturn("PLACE 0,1,EAST", "MOVE", "REPORT", "EXIT").when(inHandler).readInput();
		robo.play();
		verify(outHandler).printOutput("Output: 1,1,EAST");

	}

	/**
	 * Test Place, Move and turn LEFT
	 */
	@Test
	public void testPlayCase3() {
		MyRoboApp robo = new MyRoboApp(inHandler, outHandler);
		doReturn("PLACE 0,1,EAST", "MOVE", "LEFT", "REPORT", "EXIT").when(inHandler).readInput();
		robo.play();
		verify(outHandler).printOutput("Output: 1,1,NORTH");
	}

	/**
	 * Test Move, left and right
	 */
	@Test
	public void testPlayCase4() {
		MyRoboApp robo = new MyRoboApp(inHandler, outHandler);
		doReturn("PLACE 0,1,EAST", "MOVE", "LEFT", "RIGHT", "REPORT", "EXIT").when(inHandler).readInput();
		robo.play();
		verify(outHandler).printOutput("Output: 1,1,EAST");
	}

	/**
	 * Place out of table, Ignores, no output, until placed
	 */
	@Test
	public void testPlayCase5() {
		MyRoboApp robo = new MyRoboApp(inHandler, outHandler);
		doReturn("PLACE 6,6,EAST", "MOVE", "LEFT", "RIGHT", "REPORT", "EXIT").when(inHandler).readInput();
		robo.play();
		verify(outHandler, times(0)).printOutput("Output: -1,-1,null");
	}
	
	/**
	 * Place out of table at right, Ignores, no output, until placed
	 */
	@Test
	public void testPlayCase5_1() {
		MyRoboApp robo = new MyRoboApp(inHandler, outHandler);
		doReturn("PLACE 6,2,EAST", "MOVE", "LEFT", "RIGHT", "REPORT", "EXIT").when(inHandler).readInput();
		robo.play();
		verify(outHandler, times(0)).printOutput("Output: -1,-1,null");
	}
	
	/**
	 * Place out of table at north, Ignores, no output, until placed
	 */
	@Test
	public void testPlayCase5_2() {
		MyRoboApp robo = new MyRoboApp(inHandler, outHandler);
		doReturn("PLACE 2,6,NORTH", "MOVE", "LEFT", "RIGHT", "REPORT", "EXIT").when(inHandler).readInput();
		robo.play();
		verify(outHandler, times(0)).printOutput("Output: -1,-1,null");
	}
	
	/**
	 * Place out of table at west, Ignores, no output, until placed
	 */
	@Test
	public void testPlayCase5_3() {
		MyRoboApp robo = new MyRoboApp(inHandler, outHandler);
		doReturn("PLACE -2,2,WEST", "MOVE", "LEFT", "RIGHT", "REPORT", "EXIT").when(inHandler).readInput();
		robo.play();
		verify(outHandler, times(0)).printOutput("Output: -1,-1,null");
	}
	
	/**
	 * Place out of table at south, Ignores, no output, until placed
	 */
	@Test
	public void testPlayCase5_4() {
		MyRoboApp robo = new MyRoboApp(inHandler, outHandler);
		doReturn("PLACE 2,-2,SOUTH", "MOVE", "LEFT", "RIGHT", "REPORT", "EXIT").when(inHandler).readInput();
		robo.play();
		verify(outHandler, times(0)).printOutput("Output: -1,-1,null");
	}
	
	/**
	 * Place wrong direction, no output, until placed
	 */
	@Test
	public void testPlayCase5_5() {
		MyRoboApp robo = new MyRoboApp(inHandler, outHandler);
		doReturn("PLACE 2,-2,XXX", "MOVE", "LEFT", "RIGHT", "REPORT", "EXIT").when(inHandler).readInput();
		robo.play();
		verify(outHandler, times(0)).printOutput("Output: -1,-1,null");
	}

	/**
	 * Moving EAST beyond table, stops at border
	 */
	@Test
	public void testPlayCase6() {
		MyRoboApp robo = new MyRoboApp(inHandler, outHandler);
		doReturn("PLACE 4,4,EAST", "MOVE", "MOVE", "MOVE", "REPORT", "EXIT").when(inHandler).readInput();
		robo.play();
		verify(outHandler).printOutput("Output: 5,4,EAST");
	}

	/**
	 * Moving WEST beyond table, stops at border
	 */
	@Test
	public void testPlayCase6_1() {
		MyRoboApp robo = new MyRoboApp(inHandler, outHandler);
		doReturn("PLACE 2,2,WEST", "MOVE", "MOVE", "MOVE", "MOVE", "MOVE", "REPORT", "EXIT").when(inHandler)
				.readInput();
		robo.play();
		verify(outHandler).printOutput("Output: 0,2,WEST");
	}

	/**
	 * Moving SOUTH beyond table, stops at border
	 */
	@Test
	public void testPlayCase6_2() {
		MyRoboApp robo = new MyRoboApp(inHandler, outHandler);
		doReturn("PLACE 2,2,SOUTH", "MOVE", "MOVE", "MOVE", "MOVE", "MOVE", "REPORT", "EXIT").when(inHandler)
				.readInput();
		robo.play();
		verify(outHandler).printOutput("Output: 2,0,SOUTH");
	}

	/**
	 * Moving NORTH beyond table, stops at border
	 */
	@Test // Moving NORTH beyond table, stops at border
	public void testPlayCase6_3() {
		MyRoboApp robo = new MyRoboApp(inHandler, outHandler);
		doReturn("PLACE 2,2,NORTH", "MOVE", "MOVE", "MOVE", "MOVE", "MOVE", "REPORT", "EXIT").when(inHandler)
				.readInput();
		robo.play();
		verify(outHandler).printOutput("Output: 2,5,NORTH");
	}

	/**
	 * Turn left full cycle
	 */
	@Test
	public void testPlayCase7() {
		MyRoboApp robo = new MyRoboApp(inHandler, outHandler);
		doReturn("PLACE 4,4,EAST", "LEFT", "LEFT", "LEFT", "LEFT", "REPORT", "EXIT").when(inHandler).readInput();
		robo.play();
		verify(outHandler).printOutput("Output: 4,4,EAST");
	}

	/**
	 * Turn right full cycle
	 */
	@Test
	public void testPlayCase8() {
		MyRoboApp robo = new MyRoboApp(inHandler, outHandler);
		doReturn("PLACE 4,4,WEST", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "REPORT", "EXIT").when(inHandler).readInput();
		robo.play();
		verify(outHandler).printOutput("Output: 4,4,WEST");
	}

}
