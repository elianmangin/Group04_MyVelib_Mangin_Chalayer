package myVelibProject.system.core;

/**
 * This class defines the characteristics of a bicycle.
 * <p>
 * It consists of the different attribute of the bicycle which has no particular method.
 * In our system, the bicycles are passive objects. They can be rented by the users.
 * </p>
 */
public class Bicycle {
	protected static int idCounterBicycle = 0;
	protected int uniqID;
	protected Coordinates gps;
	protected String type;
	protected boolean inStation;
	protected boolean currentlyRentedBicycle;
	
	/** Creates a bicycle with given coordinates, a given type (mecanical or electrical) and set its status (inStation and 
	 * currentlyRentedBicycle) to false.*/
	public Bicycle(Coordinates gps, String type) {
		super();
		idCounterBicycle++;
		this.uniqID = idCounterBicycle;
		this.gps = gps;
		this.type = type;
		this.inStation = false;
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
