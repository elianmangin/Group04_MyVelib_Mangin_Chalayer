package myVelibProject;

public class ParkingSlot {
	protected static int uniqIDCounter = 0;
	protected int uniqID;
	protected boolean status; //True if occupied False if empty
	protected Bicycle parkedBicycle;
	
	public ParkingSlot() {
		super();
		uniqIDCounter++;
		uniqID = uniqIDCounter;
		this.status = false;
		this.parkedBicycle = null;
		
	}
	
	public ParkingSlot(Bicycle parkedBicycle) {
		super();
		uniqIDCounter++;
		uniqID = uniqIDCounter;
		this.status = true;
		this.parkedBicycle = parkedBicycle;
	}
	
	
	
	void addBicycle(Bicycle bicycle) {
		if (status) {
			System.out.print("Warning this slot is already occupied");
		}
		else{
			status = true;
			parkedBicycle = bicycle;
		}
	}
	
	void removeBicycle() {
		if (!status) {
			System.out.print("Warning this slot is not occupied");
		}
		else{
			status = false;
			parkedBicycle = null;
		}
	}
	
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
