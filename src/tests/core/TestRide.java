package tests.core;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import system.core.*;



class TestRide {
	private User u;
	private LocalTime st;
	private LocalTime et;
	private DockingStation sds;
	private DockingStation eds;
	private Bicycle b;

	@BeforeEach
	void setUp() throws GeneralException {
		this.u = new User("Jean", new Coordinates(1.234,1.546), "Vlibre", 100);
		this.st = LocalTime.of(6, 45);
		this.et = LocalTime.of(10, 15);
		this.sds = new DockingStation(new Coordinates(6.908,4.767),"plus",10);
		this.eds = new DockingStation(new Coordinates(2.301,8.547),null,10);
		this.b = new Bicycle(new Coordinates(7.151,1.677), "mecanical");

	}
	@Test
	/**test the different setter usable when the ride is started*/
	void testGettersStartOfTheRide() {
		Ride rideds = new Ride(u, sds, b, st);
		Ride ride = new Ride(u, b, st);
		assertEquals(u,ride.getUser());
		assertEquals(u,rideds.getUser());
		assertEquals(b,ride.getBicycleUsed());
		assertEquals(b,rideds.getBicycleUsed());
		assertEquals(null,ride.getStartStation());
		assertEquals(sds,rideds.getStartStation());
		assertEquals(st,ride.getStartTime());
		assertEquals(st,rideds.getStartTime());
	}

	@Test
	/** test the different setter usable when the ride is ended*/
	void testGettersEndOfTheRide() throws GeneralException {
		Ride rideStreetToStreet = new Ride(u, b, st);
		Ride rideStreetToDockingStation = new Ride(u, b, st);
		Ride rideDockingStationToStreet = new Ride(u, sds, b, st);
		Ride rideDockingStationToDockingStation = new Ride(u, sds, b, st);
		rideStreetToStreet.endRide(new Coordinates(1.520,1.260), et);
		rideStreetToDockingStation.endRide(eds, et);
		rideDockingStationToStreet.endRide(new Coordinates(16.460,54.260), et);
		rideDockingStationToDockingStation.endRide(eds, et);
		assertEquals(rideDockingStationToDockingStation.getEndStation(), eds);
		assertEquals(rideStreetToDockingStation.getEndStation(), eds);
		assertTrue(rideStreetToStreet.getEndCoordinates().equals(new Coordinates(1.520,1.260)));
		assertTrue(rideDockingStationToStreet.getEndCoordinates().equals(new Coordinates(16.460,54.260)));
		assertEquals(rideStreetToStreet.getEndTime(),et);
		assertEquals(rideStreetToDockingStation.getEndTime(),et);
		assertEquals(rideDockingStationToStreet.getEndTime(),et);
		assertEquals(rideDockingStationToDockingStation.getEndTime(),et);
	}


	@Test
	/** Assert an exception is thrown if the time is not coherent*/
	void testCoherenceOfTime() throws GeneralException {
		assertTrue(et.isAfter(st));
		Ride ridetrue = new Ride(u, b, st);
		ridetrue.endRide(new Coordinates(1.520,1.260), et);
		assertTrue(ridetrue.getEndTime().isAfter(ridetrue.getStartTime()));

		assertThrows(GeneralException.class, () -> {
			Ride ridefalse = new Ride(u, b, et);
			ridefalse.endRide(new Coordinates(1.520,1.260), st);
		});
	}

	@Test
	/** Assert  if the bicycle is where it is supposed to be at the end of the ride*/
	void testCoherenceOfCoordinates() throws GeneralException {
		Ride ride = new Ride(u, b, st);
		ride.endRide(new Coordinates(1.520,1.260), et);
		assertTrue(ride.getEndCoordinates().equals(ride.getBicycleUsed().getGps()));
	}






}





