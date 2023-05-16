package myVelibProject;

public class ParkingSlot {
	protected static int uniqIDCounterParkingSlot;
	protected int uniqIDParkingSlot;
	protected boolean status; //True if occupied False if empty
	protected Bicycle parkedBicycle;
	
	public ParkingSlot(Bicycle parkedBicycle) {
		super();
		this.status = true;
		this.parkedBicycle = parkedBicycle;
		uniqIDCounterParkingSlot++;
		uniqIDParkingSlot = uniqIDCounterParkingSlot;
	}
	
	public ParkingSlot() {
		super();
		this.status = false;
		this.parkedBicycle = null;
		uniqIDCounterParkingSlot++;
		uniqIDParkingSlot = uniqIDCounterParkingSlot;
	}
	
	void addBicycle(Bicycle bicycle,DockingStation dockingStation) {
		if (status) {
			System.out.print("Warning this slot is already occupied");
		}
		else{
			status = true;
			parkedBicycle = bicycle;
			dockingStation.numberOfSlotsOccupied++;
			if(parkedBicycle.getType() == "mecanical") {dockingStation.numberOfMecanicalBicycle++;}
			if(parkedBicycle.getType() == "electrical") {dockingStation.numberOfElectricalBicycle++;}
		}
	}
	
	void removeBicycle(DockingStation dockingStation) {
		if (!status) {
			System.out.print("Warning this slot is not occupied");
		}
		else{
			status = false;
			dockingStation.numberOfSlotsOccupied--;
			if(parkedBicycle.getType() == "mecanical") {dockingStation.numberOfMecanicalBicycle--;}
			if(parkedBicycle.getType() == "electrical") {dockingStation.numberOfElectricalBicycle--;}
			parkedBicycle = null;
		}
	}
	
	public int getUniqIDParkingSlot() {
		return uniqIDParkingSlot;
	}
	public void setUniqIDParkingSlot(int uniqIDParkingSlot) {
		this.uniqIDParkingSlot = uniqIDParkingSlot;
	}
	public boolean isStatus() {
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
		return "ParkingSlot [uniqIDParkingSlot=" + uniqIDParkingSlot + ", Slot is occupied =" + status + ", parkedBicycle="
				+ parkedBicycle + "]";
	}
	
}
