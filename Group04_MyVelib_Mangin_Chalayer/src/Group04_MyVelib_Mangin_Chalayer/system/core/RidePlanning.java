package Group04_MyVelib_Mangin_Chalayer.system.core;

/**
 * RidePlanning to use to provide an itinerary to a user.
 */
public interface RidePlanning {

	@SuppressWarnings("rawtypes")
	/** Return the RideItinerary for a given start, end and type of bike.*/
	public RideItinerary plan(Coordinates start, Coordinates end, String type) throws GeneralException;

}
