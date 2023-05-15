package myVelibProject;

import java.util.ArrayList;

public class RidePlanning {
	protected MyVelib myvelib;
	
	public RidePlanning(MyVelib myvelib) {
		super();
		this.myvelib = myvelib;
	}
	
	public double distanceBetween(Coordinates coord1,Coordinates coord2) {
		return Math.sqrt(Math.pow(coord1.getLatitude()-coord2.getLatitude(),2)+Math.pow(coord1.getLongitude()-coord2.getLongitude(),2));
	}
	
	public DockingStation ridePlanning(Coordinates startingCoordinates,Coordinates endingCoordinates) {
		ArrayList<DockingStation> dockingStationList = myvelib.getStationList();
		return
		
		
		
	}

}
