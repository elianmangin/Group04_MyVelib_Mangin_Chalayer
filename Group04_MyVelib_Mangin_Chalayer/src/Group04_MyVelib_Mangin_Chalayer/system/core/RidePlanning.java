package Group04_MyVelib_Mangin_Chalayer.system.core;

public interface RidePlanning {

	@SuppressWarnings("rawtypes")
	public RideItinerary plan(Coordinates start, Coordinates end, String type) throws GeneralException;

}
