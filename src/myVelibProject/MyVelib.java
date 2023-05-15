package myVelibProject;

import java.util.ArrayList;
import java.util.Collections;

public class MyVelib {
	protected ArrayList<Bicycle> bicycleList;
	protected ArrayList<User> userList;
	protected ArrayList<DockingStation> stationList;
	protected ArrayList<Ride> rideList;
	
	public MyVelib() {
		super();
		bicycleList = new ArrayList<Bicycle>();
		userList = new ArrayList<User>();
		stationList = new ArrayList<DockingStation>();
		rideList = new ArrayList<Ride>();
	}
	
	public void addBicycle(Bicycle bicycle) {
		bicycleList.add(bicycle);
	}
	public void addDockingStation(DockingStation dockingStation) {
		stationList.add(dockingStation);
	}
	
	public ArrayList<DockingStation> SortByMostUsedStation(ArrayList<DockingStation> dockingStationList){
		ComparatorByMostUsedStation comparatorByMostUsedStation = new ComparatorByMostUsedStation();
		Collections.sort(dockingStationList,comparatorByMostUsedStation);
		return dockingStationList;
	}
	public ArrayList<DockingStation> SortByLeastOccupiedStation(ArrayList<DockingStation> dockingStationList){
		ComparatorByLeastOccupiedStation comparatorByMostUsedStation = new ComparatorByLeastOccupiedStation();
		Collections.sort(dockingStationList,comparatorByMostUsedStation);
		return dockingStationList;
	}
	
	public void addUser(User user) {
		userList.add(user);
	}
	public void addRide(Ride ride) {
		rideList.add(ride);
	}
	
	
	
	@Override
	public String toString() {
		return "MyVelib [bicycleList=" + bicycleList + ", userList=" + userList + ", stationList=" + stationList
				+ ", rideList=" + rideList + "]";
	}
	public ArrayList<Bicycle> getBicycleList() {
		return bicycleList;
	}
	public ArrayList<User> getUserList() {
		return userList;
	}
	public ArrayList<DockingStation> getStationList() {
		return stationList;
	}
	public ArrayList<Ride> getRideList() {
		return rideList;
	}
	
	

}
