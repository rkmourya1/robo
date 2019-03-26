package robo.io;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.Test;

/**
 * Test cases for testing OutputHandler and InputHandler
 * 
 * @author Raghwendra
 *
 */
public class IOHandlersTest {

	/**
	 * Test OutputHandler
	 */
	@Test
	public void testOutputHandler() {
		OutputHandler outHandler = new StdOutputHandlerImpl();
		OutputHandler outHandlerSpy = spy(outHandler);
		outHandlerSpy.printOutput("test");
		verify(outHandlerSpy).printOutput("test");
	}

	/**
	 * Test InputHandler
	 */
	@Test
	public void testInputHandler() {
		InputHandler inHandler = new StdInputHandlerImpl();
		InputHandler inHandlerSpy = spy(inHandler);
		inHandlerSpy.close();
		verify(inHandlerSpy).close();
	}

}
