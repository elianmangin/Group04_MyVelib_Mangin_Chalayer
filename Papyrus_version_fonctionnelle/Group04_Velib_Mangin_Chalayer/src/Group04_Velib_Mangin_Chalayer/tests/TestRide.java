package Group04_Velib_Mangin_Chalayer.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import Group04_Velib_Mangin_Chalayer.system.Bicycle;
import Group04_Velib_Mangin_Chalayer.system.Coordinates;
import Group04_Velib_Mangin_Chalayer.system.DockingStation;
import Group04_Velib_Mangin_Chalayer.system.User;

class TestRide {
	private User u;
	private Coordinates sc;
	private Coordinates ec;
	private LocalTime st;
	private LocalTime et;
	private DockingStation sds;
	private DockingStation eds;
	private Bicycle b;

	@Test
	void testDockToDock1() {
		//Velo en station null jusqu'à une station null 30min VLibre
		//sds = new DockingStation(new Coordinates(48.72599238205871, 2.261531176930589), "online", null, 30, null, null);
	}

}
