package myVelibProject.system.core;

public class Bicycle {
	protected static int idCounterBicycle = 0;
	protected int uniqID;
	protected Coordinates gps;
	protected String type;
	protected boolean inStation;
	protected boolean currentlyRentedBicycle;
	
	public Bicycle(Coordinates gps, String type) {
		super();
		idCounterBicycle++;
		this.uniqID = idCounterBicycle;
		this.gps = gps;
		this.type = type;
		this.inStation = true;
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
	
	public static void setIdCounterBicycle(int idCounterBicycle) {
		Bicycle.idCounterBicycle = idCounterBicycle;
	}
	
	public void setInStation(boolean b) {
		this.inStation = b;
	}
	
	public boolean getInStation() {
		return inStation;
	}

	@Override
	public String toString() {
		return "\n\t\tBicycle number " + uniqID + "\nCoordinates : " + gps + "\nType : " + type + "\nCurrently rented : "
				+ currentlyRentedBicycle;
	}
	
	
	
	
	
	
	
	

}
