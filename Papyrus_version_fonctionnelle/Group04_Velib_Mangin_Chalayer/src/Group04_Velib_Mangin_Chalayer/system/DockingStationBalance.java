package Group04_Velib_Mangin_Chalayer.system;

public class DockingStationBalance {
	protected int totalNumberOfRent;
	protected int totalNumberOfReturn;
	
	public DockingStationBalance() {
		super();
		totalNumberOfRent=0;
		totalNumberOfReturn=0;
	}
	
	public void addrent() {
		totalNumberOfRent++;
	}
	
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
