package Group04_MyVelib_Mangin_Chalayer.system.core;

/**
 * This class defines the balance of a docking station.
 * <p>
 * This balance store the number of rent and return operation of the station.
 * @see DockingStation
 * </p>
 */
public class DockingStationBalance {
	protected int totalNumberOfRent;
	protected int totalNumberOfReturn;
	
	/** Creates a balance and initialize its values to zero.*/
	public DockingStationBalance() {
		super();
		totalNumberOfRent=0;
		totalNumberOfReturn=0;
	}
	
	/** Increments the number of rent operation (+1)*/
	public void addrent() {
		totalNumberOfRent++;
	}
	
	/** Increments the number of return operation (+1)*/
	public void addreturn() {
		totalNumberOfReturn++;
	}


	// Getters, Setters, toString
	@Override
	public String toString() {
		return "[RENTS=" + totalNumberOfRent + ", RETURNS="
				+ totalNumberOfReturn + "]";
	}
	public int getTotalNumberOfRent() {
		return totalNumberOfRent;
	}
	public int getTotalNumberOfReturn() {
		return totalNumberOfReturn;
	}

}
