package system.core;

/** Store a starting docking station and ending coordinates with a bicycle type.*/
public class StationToStreetItinerary extends RideItinerary<DockingStation, Coordinates> {

	public StationToStreetItinerary(DockingStation start, Coordinates end, String type) {
		super(start, end, type);
		// TODO Auto-generated constructor stub
	}

}
