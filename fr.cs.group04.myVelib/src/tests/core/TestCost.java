package tests.core;

/**
 * Junit test of the @see methods to compute the cost of a ride
 */
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import system.core.*;

class TestCost {
	private CostFactory factory = new CostFactory();
	private CostStrategy strategy;
	private Ride rideMecanical;
	private Ride rideElectrical;
	private User u;
	private LocalTime st;
	private LocalTime et;
	private DockingStation sds;
	private DockingStation eds;
	private Bicycle be;
	private Bicycle bm;
	
	
	@BeforeEach
	void setUp() throws GeneralException {
		u = new User("Jean", new Coordinates(1.234,1.546), "Vlibre", 100);
		st = LocalTime.of(6, 45);
		et = LocalTime.of(10, 15);
		sds = new DockingStation(new Coordinates(6.908,4.767),"plus",10);
		eds = new DockingStation(new Coordinates(2.301,8.547),null,10);
		bm= new Bicycle(new Coordinates(7.151,1.677), "mecanical");
		be= new Bicycle(new Coordinates(7.151,1.677), "electrical");
		
	}
	
	@Test
	/**test the cost computing for this specific case with a mecanical and an electrical bike*/
	void testVlibreStationToStreet() throws GeneralException {
		rideElectrical = new Ride(u,sds, be, st);
		rideMecanical = new Ride(u,sds, bm, st);
		rideElectrical.endRide(new Coordinates(1.520,1.260), et);
		rideMecanical.endRide(new Coordinates(1.520,1.260), et);
		strategy = factory.create("Vlibre");
		double costElectrical = strategy.calculate(rideElectrical);
		double costMecanical = strategy.calculate(rideMecanical);
		assertEquals(costElectrical, (1+2.5*2)*1.1);
		assertEquals(costMecanical, 2.5*1.1);
	}
	
	@Test
	/**test the cost computing for this specific case with a mecanical and an electrical bike*/
	void testVlibreStreetToStreet() throws GeneralException {
		rideElectrical = new Ride(u, be, st);
		rideMecanical = new Ride(u, bm, st);
		rideElectrical.endRide(new Coordinates(1.520,1.260), et);
		rideMecanical.endRide(new Coordinates(1.520,1.260), et);
		strategy = factory.create("Vlibre");
		double costElectrical = strategy.calculate(rideElectrical);
		double costMecanical = strategy.calculate(rideMecanical);
		assertEquals(costElectrical, (1+2.5*2)*1.1);
		assertEquals(costMecanical, 2.5*1.1);
	}
	
	@Test
	/**test the cost computing for this specific case with a mecanical and an electrical bike*/
	void testVlibreStreetToStation() throws GeneralException {
		rideElectrical = new Ride(u, be, st);
		rideMecanical = new Ride(u, bm, st);
		rideElectrical.endRide(eds, et);
		rideMecanical.endRide(eds, et);
		strategy = factory.create("Vlibre");
		double costElectrical = strategy.calculate(rideElectrical);
		double costMecanical = strategy.calculate(rideMecanical);
		assertEquals(costElectrical, (1+2.5*2)*0.9);
		assertEquals(costMecanical, 2.5*0.9);
	}
	
	@Test
	/**test the cost computing for this specific case with a mecanical and an electrical bike*/
	void testVlibreStationToStation() throws GeneralException {
		rideElectrical = new Ride(u,sds, be, st);
		rideMecanical = new Ride(u,sds, bm, st);
		rideElectrical.endRide(eds, et);
		rideMecanical.endRide(eds, et);
		strategy = factory.create("Vlibre");
		double costElectrical = strategy.calculate(rideElectrical);
		double costMecanical = strategy.calculate(rideMecanical);
		assertEquals(costElectrical, (1+2.5*2));
		assertEquals(costMecanical, 2.5);
	}
	
	@Test
	/**test the cost computing for this specific case with a mecanical and an electrical bike*/
	void testVmaxStationToStation() throws GeneralException {
		rideElectrical = new Ride(u,sds, be, st);
		rideMecanical = new Ride(u,sds, bm, st);
		rideElectrical.endRide(eds, et);
		rideMecanical.endRide(eds, et);
		strategy = factory.create("Vmax");
		double costElectrical = strategy.calculate(rideElectrical);
		double costMecanical = strategy.calculate(rideMecanical);
		assertEquals(costElectrical, 2.5);
		assertEquals(costMecanical, 2.5);
	}
	
	@Test
	/**test the cost computing for this specific case with a mecanical and an electrical bike*/
	void testVmaxStationToStreet() throws GeneralException {
		rideElectrical = new Ride(u,sds, be, st);
		rideMecanical = new Ride(u,sds, bm, st);
		rideElectrical.endRide(new Coordinates(1.520,1.260), et);
		rideMecanical.endRide(new Coordinates(1.520,1.260), et);
		strategy = factory.create("Vmax");
		double costElectrical = strategy.calculate(rideElectrical);
		double costMecanical = strategy.calculate(rideMecanical);
		assertEquals(costElectrical, 2.5*1.1);
		assertEquals(costMecanical, 2.5*1.1);
	}
	@Test
	/**test the cost computing for this specific case with a mecanical and an electrical bike*/
	void testVmaxStreetToStreet() throws GeneralException {
		rideElectrical = new Ride(u, be, st);
		rideMecanical = new Ride(u, bm, st);
		rideElectrical.endRide(new Coordinates(1.520,1.260), et);
		rideMecanical.endRide(new Coordinates(1.520,1.260), et);
		strategy = factory.create("Vmax");
		double costElectrical = strategy.calculate(rideElectrical);
		double costMecanical = strategy.calculate(rideMecanical);
		assertEquals(costElectrical, 2.5*1.1);
		assertEquals(costMecanical, 2.5*1.1);
	}
	
	@Test
	/**test the cost computing for this specific case with a mecanical and an electrical bike*/
	void testVmaxStreetToStation() throws GeneralException {
		rideElectrical = new Ride(u, be, st);
		rideMecanical = new Ride(u, bm, st);
		rideElectrical.endRide(eds, et);
		rideMecanical.endRide(eds, et);
		strategy = factory.create("Vmax");
		double costElectrical = strategy.calculate(rideElectrical);
		double costMecanical = strategy.calculate(rideMecanical);
		assertEquals(costElectrical, 2.5*0.9);
		assertEquals(costMecanical, 2.5*0.9);
	}
	
	
	@Test
	/**test the cost computing for this specific case with a mecanical and an electrical bike*/
	void testNoCardStationToStation() throws GeneralException {
		rideElectrical = new Ride(u,sds, be, st);
		rideMecanical = new Ride(u,sds, bm, st);
		rideElectrical.endRide(eds, et);
		rideMecanical.endRide(eds, et);
		strategy = factory.create(null);
		double costElectrical = strategy.calculate(rideElectrical);
		double costMecanical = strategy.calculate(rideMecanical);
		assertEquals(costElectrical, 2*3.5);
		assertEquals(costMecanical, 3.5);
	}
	
	@Test
	/**test the cost computing for this specific case with a mecanical and an electrical bike*/
	void testNoCardStationToStreet() throws GeneralException {
		rideElectrical = new Ride(u,sds, be, st);
		rideMecanical = new Ride(u,sds, bm, st);
		rideElectrical.endRide(new Coordinates(1.520,1.260), et);
		rideMecanical.endRide(new Coordinates(1.520,1.260), et);
		strategy = factory.create(null);
		double costElectrical = strategy.calculate(rideElectrical);
		double costMecanical = strategy.calculate(rideMecanical);
		assertEquals(costElectrical, 2*3.5*1.1);
		assertEquals(costMecanical, 3.5*1.1);
	}
	@Test
	/**test the cost computing for this specific case with a mecanical and an electrical bike*/
	void testNoCardStreetToStreet() throws GeneralException {
		rideElectrical = new Ride(u, be, st);
		rideMecanical = new Ride(u, bm, st);
		rideElectrical.endRide(new Coordinates(1.520,1.260), et);
		rideMecanical.endRide(new Coordinates(1.520,1.260), et);
		strategy = factory.create(null);
		double costElectrical = strategy.calculate(rideElectrical);
		double costMecanical = strategy.calculate(rideMecanical);
		assertEquals(costElectrical, 2*3.5*1.1);
		assertEquals(costMecanical, 3.5*1.1);
	}
	
	@Test
	/**test the cost computing for this specific case with a mecanical and an electrical bike*/
	void testNoCardStreetToStation() throws GeneralException {
		rideElectrical = new Ride(u, be, st);
		rideMecanical = new Ride(u, bm, st);
		rideElectrical.endRide(eds, et);
		rideMecanical.endRide(eds, et);
		strategy = factory.create(null);
		double costElectrical = strategy.calculate(rideElectrical);
		double costMecanical = strategy.calculate(rideMecanical);
		assertEquals(costElectrical, 2*3.5*0.9);
		assertEquals(costMecanical, 3.5*0.9);
	}
	
}
