package system.core;

/**
 * Stores a starting location, an ending location and the type of bike used.
 * <p>
 * A start (respectively an end) can be from a station or from the street. That's why we use here generic types.
 * @see StationToStationItinerary
 * @see StationToStreetItinerary
 * @see StreetToStationItinerary
 * @see StreetToStreetItinerary
 * </p>
 */
public abstract class RideItinerary<S, E> {
	protected S start;
	protected E end;
	protected String type;
	
	/** Create an object with given start, end and type of bicycle.*/
	public RideItinerary(S start, E end, String type) {
		super();
		this.start = start;
		this.end = end;
		this.type = type;
	}
	@Override
	public String toString() {
		return "RideItinerary from" + start + " to "+ end;
	}

	public S getStart() {
		return start;
	}
	public void setStart(S start) {
		this.start = start;
	}
	public E getEnd() {
		return end;
	}
	public void setEnd(E end) {
		this.end = end;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}



}
