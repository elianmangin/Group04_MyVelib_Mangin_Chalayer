package myVelibProject;

import java.util.ArrayList;

public class DockingStation {
	protected static int idCounter = 0;
	protected int uniqID;
	protected Coordinates gps;
	protected String status; //online or offline
	protected String type; // plus or null
	protected int numberOfSlots;
	protected int numberOfSlotsOccupied;
	protected ArrayList<ParkingSlot> parkingSlotList;
	protected DockingStationBalance dockingStationBalance;
	protected int numberOfMecanicalBicycle;
	protected int numberOfElectricalBicycle;
	
	public DockingStation(Coordinates coordinatesStation, String type, int numberOfSlots) {
		super();
		idCounter++;
		this.uniqID = idCounter;
		this.gps = coordinatesStation;
		this.status = "online";
		this.type = type;
		this.numberOfSlots = numberOfSlots;
		this.numberOfSlotsOccupied = 0;
		this.parkingSlotList = new ArrayList<ParkingSlot>();
		this.dockingStationBalance = new DockingStationBalance();
		this.numberOfElectricalBicycle = 0;
		this.numberOfMecanicalBicycle = 0;
		
		for (int i = 0; i < numberOfSlots; i++) {
			this.parkingSlotList.add(new ParkingSlot());
		}
		
	}
	
	public void addBicycle(Bicycle B) throws GeneralException {
		if (this.numberOfSlotsOccupied < this.numberOfSlots) {
			for (ParkingSlot parkingSlot : parkingSlotList) {
				if (!parkingSlot.isOccupied()) {
					B.setGps(this.gps);
					B.setCurrentlyRentedBicycle(false);
					parkingSlot.addBicycle(B);
					this.numberOfSlotsOccupied++;
					if(B.getType() == "mecanical") {this.numberOfMecanicalBicycle++;}
					if(B.getType() == "electrical") {this.numberOfElectricalBicycle++;}	
				}
			}
			throw new GeneralException("Error adding bicycle");
		}
		else {
			throw new GeneralException("Warning : this station is full");
		}
	}
	
	public Bicycle takeBicycle(String type) throws GeneralException {
		if (type == "mecanical" && this.numberOfMecanicalBicycle > 0) {
			for (ParkingSlot parkingSlot : parkingSlotList) {
				if (parkingSlot.parkedBicycle.getType() == "mecanical") {
					Bicycle B = parkingSlot.parkedBicycle;
					parkingSlot.removeBicycle();
					this.numberOfSlotsOccupied--;
					this.numberOfMecanicalBicycle--;
					return B;
				}
			}
			throw new GeneralException("Error taking bicycle");
		}
		else if (type == "electrical" && this.numberOfElectricalBicycle > 0) {
			for (ParkingSlot parkingSlot : parkingSlotList) {
				if (parkingSlot.parkedBicycle.getType() == "electrical") {
					Bicycle B = parkingSlot.parkedBicycle;
					parkingSlot.removeBicycle();
					this.numberOfSlotsOccupied--;
					this.numberOfElectricalBicycle--;
					return B;
				}
			}
			throw new GeneralException("Error taking bicycle");
		}
		else {
			throw new GeneralException("No bicycle of the required type in this station");
		}
	}

	
	// Getters, Setters, toString
	@Override
	public String toString() {
		return "\t\tStation number " + uniqID + "\nCoordinates : " + gps+ "\n STATUS :" + status + "\nSLOTS : " + numberOfSlots 
				+ "\nBALANCE :"+ dockingStationBalance;
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

	public int getNumberOfSlotsOccupied() {
		return numberOfSlotsOccupied;
	}

	public void setNumberOfSlotsOccupied(int numberOfSlotsOccupied) {
		this.numberOfSlotsOccupied = numberOfSlotsOccupied;
	}

	public ArrayList<ParkingSlot> getParkingSlotList() {
		return parkingSlotList;
	}

	public int getUniqID() {
		return uniqID;
	}

	public Coordinates getGps() {
		return gps;
	}

	public int getNumberOfSlots() {
		return numberOfSlots;
	}

	public DockingStationBalance getDockingStationBalance() {
		return dockingStationBalance;
	}
	

	

}
