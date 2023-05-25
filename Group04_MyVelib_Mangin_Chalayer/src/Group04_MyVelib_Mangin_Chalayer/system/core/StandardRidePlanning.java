package Group04_MyVelib_Mangin_Chalayer.system.core;

import java.util.ArrayList;
import java.util.Collections;

public class StandardRidePlanning implements RidePlanning{
	protected MyVelib myvelib;

	public StandardRidePlanning(MyVelib myvelib) {
		super();
		this.myvelib = myvelib;
	}


	@Override
	public StationToStationItinerary plan(Coordinates startingCoordinates,Coordinates endingCoordinates,String type) throws GeneralException{

		//Initialisation

		ArrayList<DockingStation> possibleStartingDockingStationList = new ArrayList<>();
		ComparatorByDistanceStation startComparator = new ComparatorByDistanceStation(startingCoordinates);
		ArrayList<DockingStation> possibleEndingDockingStationList = new ArrayList<>();
		ComparatorByDistanceStation endComparator = new ComparatorByDistanceStation(endingCoordinates);


		//Create possible station lists

		if(type.equals("electrical")) {
			for (DockingStation dockingStation : myvelib.getStationList()) {
				if (dockingStation.getNumberOfElectricalBicycle() > 0) {
					possibleStartingDockingStationList.add(dockingStation);
				}
			}
		}
		if(type.equals("mecanical")) {
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
			throw new GeneralException("No itinerary possible");
		}

		DockingStation startingDockingStation = possibleStartingDockingStationList.get(0);
		DockingStation endingDockingStation = possibleEndingDockingStationList.get(0);

		return new StationToStationItinerary(startingDockingStation, endingDockingStation, type);
	}

}
