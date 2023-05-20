package myVelibProject;

public class Bicycle {
	protected static int idCounter=0;
	protected int uniqID;
	protected Coordinates gps;
	protected String type;
	protected boolean currentlyRentedBicycle;
	
	public Bicycle(Coordinates gps, String type) {
		super();
		this.idCounter++;
		this.uniqID = idCounter;
		this.gps = gps;
		this.type = type;
		this.currentlyRentedBicycle = false;
	}

	public Coordinates getGps() {
		return gps;
	}

	public void setGps(Coordinates gps) {
		this.gps = gps;
	}

	public boolean isCurrentlyRentedBicycle() {
		return currentlyRentedBicycle;
	}

	public void setCurrentlyRentedBicycle(boolean currentlyRentedBicycle) {
		this.currentlyRentedBicycle = currentlyRentedBicycle;
	}

	public int getUniqID() {
		return uniqID;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "\t\tBicycle number " + uniqID + "\nCoordinates : " + gps + "\nType : " + type + "\nCurrently rented : "
				+ currentlyRentedBicycle;
	}
	
	
	
	
	
	
	
	

}
