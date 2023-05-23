package myVelibProject.system.core;

public abstract class RideItinerary<S, E> {
	protected S start;
	protected E end;
	protected String type;
	
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
