package system.CLUI;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class is define as a JUnit test to launch the scenarios.
 * <p>
 * It is faster to launch all the scenario and we can also launch them one by one
 * </p>
 */
class RunTestScenario {

	@BeforeEach
	void setUp() {
		MyVelibSystem.startProcess();
	}

	@Test
	void testScenarioRentalOfABike() {
		System.out.println("################################"
				+ "################################################################################################");
		System.out.println("\n\nSCENARIO : RENTAL OF A BIKE");
		MyVelibCommands command = new MyVelibCommands("runtest", new ArrayList<String>(Arrays.asList("testScenarioRentalOfABike")));
		command.eval();
		System.out.println("################################");
	}
	
	@Test
	void testScenarioRidePlanning() {
		System.out.println("################################"
				+ "################################################################################################");
		System.out.println("\n\nSCENARIO : RIDE PLANNING");
		MyVelibCommands command = new MyVelibCommands("runtest", new ArrayList<String>(Arrays.asList("testScenarioRidePlanning")));
		command.eval();
		System.out.println("################################\n\n");
	}
	
	@Test
	void testScenarioSetUp() {
		System.out.println("################################"
				+ "################################################################################################");
		System.out.println("\n\nSCENARIO : SETUP");
		MyVelibCommands command = new MyVelibCommands("runtest", new ArrayList<String>(Arrays.asList("testScenarioSetUp")));
		command.eval();
		System.out.println("################################\n\n");
	}
	
	@Test
	void testScenarioStatistics() {
		System.out.println("################################"
				+ "################################################################################################");
		System.out.println("\n\nSCENARIO : STATISTICS");
		MyVelibCommands command = new MyVelibCommands("runtest", new ArrayList<String>(Arrays.asList("testScenarioStatistics")));
		command.eval();
		System.out.println("################################\n\n");
	}
	
	@Test
	void testScenarioSwitchStationType() {
		System.out.println("################################"
				+ "################################################################################################");
		System.out.println("SCENARIO : SWITCH STATION TYPE");
		MyVelibCommands command = new MyVelibCommands("runtest", new ArrayList<String>(Arrays.asList("testScenarioSwitchStationType")));
		command.eval();
		System.out.println("################################\n\n");
	}
	
	@Test
	void testScenarioVisualisation() {
		System.out.println("################################"
				+ "################################################################################################");
		System.out.println("SCENARIO : VISUALISATION");
		MyVelibCommands command = new MyVelibCommands("runtest", new ArrayList<String>(Arrays.asList("testScenarioVisualisation")));
		command.eval();
		System.out.println("################################\n\n");
	}

}
