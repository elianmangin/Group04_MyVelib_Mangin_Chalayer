package system.core;

/** Store a starting and an ending docking station with a bicycle type.*/
public class StationToStationItinerary extends RideItinerary<DockingStation, DockingStation> {

	public StationToStationItinerary(DockingStation start, DockingStation end, String type) {
		super(start, end, type);
		// TODO Auto-generated constructor stub
	}

}
