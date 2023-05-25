package Group04_MyVelib_Mangin_Chalayer.system.core;

public class ParkingSlot {
	protected static int idCounterParkingSlot = 0;
	protected int uniqID;
	protected boolean status; //True if occupied False if empty
	protected Bicycle parkedBicycle;

	public ParkingSlot() {
		super();
		idCounterParkingSlot++;
		uniqID = idCounterParkingSlot;
		this.status = false;
		this.parkedBicycle = null;

	}

	public ParkingSlot(Bicycle parkedBicycle) {
		super();
		idCounterParkingSlot++;
		uniqID = idCounterParkingSlot;
		this.status = true;
		this.parkedBicycle = parkedBicycle;
	}



	public void addBicycle(Bicycle bicycle) {
		if (status) {
			System.out.print("Warning this slot is already occupied");
		}
		else{
			status = true;
			parkedBicycle = bicycle;
		}
	}

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
