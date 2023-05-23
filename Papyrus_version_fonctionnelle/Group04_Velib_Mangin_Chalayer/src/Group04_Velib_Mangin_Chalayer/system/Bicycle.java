package Group04_Velib_Mangin_Chalayer.system;

public class Bicycle {
	protected static int idCounterBicycle = 0;
	protected int uniqID;
	protected Coordinates gps;
	protected String type;
	protected boolean currentlyRentedBicycle;
	
	public Bicycle(Coordinates gps, String type) {
		super();
		idCounterBicycle++;
		this.uniqID = idCounterBicycle;
		this.gps = gps;
		this.type = type;
		this.currentlyRentedBicycle = false;
	}

	// Getters, Setters, toString
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