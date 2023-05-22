package Group04_Velib_Mangin_Chalayer.system;

import java.util.ArrayList;
import java.util.Collections;

public class StandardRidePlanning implements RidePlanning{
	protected MyVelib myvelib;
	
	public StandardRidePlanning(MyVelib myvelib) {
		super();
		this.myvelib = myvelib;
	}
	
	
	public StationToStationItinerary plan(Coordinates startingCoordinates,Coordinates endingCoordinates,String type) {
		
		//Initialisation
		
		ArrayList<DockingStation> possibleStartingDockingStationList = new ArrayList<DockingStation>();
		ComparatorByDistanceStation startComparator = new ComparatorByDistanceStation(startingCoordinates);
		ArrayList<DockingStation> possibleEndingDockingStationList = new ArrayList<DockingStation>();
		ComparatorByDistanceStation endComparator = new ComparatorByDistanceStation(endingCoordinates);
		
		
		//Create possible station lists
		
		if(type == "electrical") {
			for (DockingStation dockingStation : myvelib.getStationList()) {
				if (dockingStation.getNumberOfElectricalBicycle() > 0) {
					possibleStartingDockingStationList.add(dockingStation);
				}
			}
		}
		if(type == "mecanical") {
			for (DockingStation dockingStation : myvelib.getStationList()) {
				if (dockingStation.getNumberOfMecanicalBicycle() > 0) {
					possibleStartingDockingStationList.add(dockingStation);
				}
			}
		}
		for (DockingStation dockingStation : myvelib.getStationList()) {
			if(dockingStation.getNumberOfSlotsOccupied()<dockingStation.getNumberOfSlots()) {
				possibleEndingDockingStationList.add(dockingStation);
			}
		}
		
		
		//Sort the list by distance get the best stations
		
		Collections.sort(possibleStartingDockingStationList,startComparator);
		Collections.sort(possibleEndingDockingStationList,endComparator);
		if(possibleEndingDockingStationList.isEmpty() || possibleStartingDockingStationList.isEmpty()) {
			System.out.print("exception trajet impossible");
		}
		
		DockingStation startingDockingStation = possibleStartingDockingStationList.get(0);
		DockingStation endingDockingStation = possibleEndingDockingStationList.get(0);
		
		return new StationToStationItinerary(startingDockingStation, endingDockingStation, type);			
	}
	
}
