package system.core;

/** Store a starting bicycle and an ending station with a bicycle type.*/
public class StreetToStationItinerary extends RideItinerary<Bicycle, DockingStation> {

	public StreetToStationItinerary(Bicycle start, DockingStation end, String type) {
		super(start, end, type);
		// TODO Auto-generated constructor stub
	}

}
