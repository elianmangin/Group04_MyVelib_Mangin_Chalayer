package myVelibProject;

public interface RidePlanning {
	
	@SuppressWarnings("rawtypes")
	public RideItinerary plan(Coordinates start, Coordinates end, String type);

}
