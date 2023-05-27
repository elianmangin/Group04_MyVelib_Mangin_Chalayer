package Group04_MyVelib_Mangin_Chalayer.system.core;

/**
 * This class defines the characteristics of a Parking Slot.
 * <p>
 * A parking slot can be occupied by a bicycle or be empty.
 * </p>
 */
public class ParkingSlot {
	protected static int idCounterParkingSlot = 0;
	protected int uniqID;
	protected boolean status; //True if occupied False if empty
	protected Bicycle parkedBicycle;
	
	/** Creates an empty parking slot.*/
	public ParkingSlot() {
		super();
		idCounterParkingSlot++;
		uniqID = idCounterParkingSlot;
		this.status = false;
		this.parkedBicycle = null;

	}
	
	/** Creates a parking slot occupied by a given bicycle.*/
	public ParkingSlot(Bicycle parkedBicycle) {
		super();
		idCounterParkingSlot++;
		uniqID = idCounterParkingSlot;
		this.status = true;
		this.parkedBicycle = parkedBicycle;
	}


	/** Park a bicycle on the slot. Set the status to true.*/
	public void addBicycle(Bicycle bicycle) {
		if (status) {
			System.out.print("Warning this slot is already occupied");
		}
		else{
			status = true;
			parkedBicycle = bicycle;
		}
	}
	
	/** Set the status to false and the parked bicycle to null.*/
	public void removeBicycle() {
		if (!status) {
			System.out.print("Warning this slot is not occupied");
		}
		else{
			status = false;
			parkedBicycle = null;
		}
	}


	// Getters, Setters, toString
	public int getUniqID() {
		return uniqID;
	}

	public boolean isOccupied() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Bicycle getParkedBicycle() {
		return parkedBicycle;
	}
	public void setParkedBicycle(Bicycle parkedBicycle) {
		this.parkedBicycle = parkedBicycle;
	}

	@Override
	public String toString() {
		return "\t\tParkingSlot number " + uniqID + "\nSlot is occupied : " + status + "\nParked Bicycle : "
				+ parkedBicycle;
	}

}
