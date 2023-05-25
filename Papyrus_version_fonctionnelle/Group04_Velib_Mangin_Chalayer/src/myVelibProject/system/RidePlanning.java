package Group04_Velib_Mangin_Chalayer.system;

public interface RidePlanning {
	
	@SuppressWarnings("rawtypes")
	public RideItinerary plan(Coordinates start, Coordinates end, String type) throws GeneralException;

}
