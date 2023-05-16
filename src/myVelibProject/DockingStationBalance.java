package myVelibProject;

public class DockingStationBalance {
	protected int totalNumberOfRent;
	protected int totalNumberOfReturn;
	
	public void addrent() {
		totalNumberOfRent++;
	}
	
	public void addreturn() {
		totalNumberOfReturn++;
	}
	
	public DockingStationBalance() {
		super();
		totalNumberOfRent=0;
		totalNumberOfReturn=0;
	}
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
