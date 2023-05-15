package myVelibProject;

public class Bicycle {
	protected static int idCounterBicycle=0;
	protected int uniqIDBicycle;
	protected Coordinates coordinatesBicycle;
	protected String type;
	protected boolean currentlyRentedBicycle;
	
	@Override
	public String toString() {
		return "Bicycle [uniqIDBicycle=" + uniqIDBicycle + ", coordinatesBicycle=" + coordinatesBicycle + ", type="
				+ type + ", currentlyRentedBicycle=" + currentlyRentedBicycle + "]";
	}

	public Bicycle(Coordinates coordinates, String type) {
		super();
		this.coordinatesBicycle = coordinates;
		this.type = type;
		idCounterBicycle++;
		uniqIDBicycle =idCounterBicycle;
		currentlyRentedBicycle = false;
	}
	
	public Coordinates getCoordinatesBicycle() {
		return coordinatesBicycle;
	}

	public void setCoordinatesBicycle(Coordinates coordinatesBicycle) {
		this.coordinatesBicycle = coordinatesBicycle;
	}

	public boolean isCurrentlyRentedBicycle() {
		return currentlyRentedBicycle;
	}

	public void setCurrentlyRentedBicycle(boolean currentlyRentedBicycle) {
		this.currentlyRentedBicycle = currentlyRentedBicycle;
	}

	public int getUniqID() {
		return uniqIDBicycle;
	}
	public void setUniqID(int uniqID) {
		this.uniqIDBicycle = uniqID;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
