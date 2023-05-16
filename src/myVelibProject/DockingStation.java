package myVelibProject;

import java.util.ArrayList;

public class DockingStation {
	protected static int idCounterStation;
	protected int uniqIDStation;
	protected Coordinates coordinatesStation;
	protected String status; //online or offline
	protected String type; // plus or null
	protected int numberOfMecanicalBicycle;
	protected int numberOfElectricalBicycle;
	

	protected int numberOfSlots;
	protected int numberOfSlotsOccupied;
	protected ArrayList<ParkingSlot> parkingSlotList;
	protected DockingStationBalance dockingStationBalance;
	
	
	public DockingStation(Coordinates coordinatesStation, String status, String type, int numberOfSlots,
			ArrayList<ParkingSlot> parkingSlotList, DockingStationBalance dockingStationBalance) {
		super();
		this.coordinatesStation = coordinatesStation;
		this.status = status;
		this.type = type;
		this.numberOfSlots = numberOfSlots;
		this.parkingSlotList = parkingSlotList;
		this.dockingStationBalance = dockingStationBalance;
		numberOfSlotsOccupied = 0;
		numberOfElectricalBicycle = 0;
		numberOfMecanicalBicycle = 0;
	}

	@Override
	public String toString() {
		return "\n[ID=" + uniqIDStation + ", GPS=" + coordinatesStation
				+ ", STATUS=" + status + ", SLOTS=" + numberOfSlots + ", BALANCE="
				+ dockingStationBalance + "]";
	}

	public int getNumberOfMecanicalBicycle() {
		return numberOfMecanicalBicycle;
	}

	public int getNumberOfElectricalBicycle() {
		return numberOfElectricalBicycle;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumberOfSlotsOccupied() {
		return numberOfSlotsOccupied;
	}

	public void setNumberOfSlotsOccupied(int numberOfSlotsOccupied) {
		this.numberOfSlotsOccupied = numberOfSlotsOccupied;
	}

	public ArrayList<ParkingSlot> getParkingSlotList() {
		return parkingSlotList;
	}

	public void setParkingSlotList(ArrayList<ParkingSlot> parkingSlotList) {
		this.parkingSlotList = parkingSlotList;
	}

	public int getUniqIDStation() {
		return uniqIDStation;
	}

	public Coordinates getCoordinatesStation() {
		return coordinatesStation;
	}

	public int getNumberOfSlots() {
		return numberOfSlots;
	}

	public DockingStationBalance getDockingStationBalance() {
		return dockingStationBalance;
	}
	

	

}
