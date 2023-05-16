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
	
	public MyVelib(int numberOfDockingStation, int numberOfParkingSlotByStation, double initialPopulationProportion,double mecanicalBicycleProportion,double plusStationProportion) {
		super();
		bicycleList = new ArrayList<Bicycle>();
		userList = new ArrayList<User>();
		stationList = new ArrayList<DockingStation>();
		rideList = new ArrayList<Ride>();
		
		//Création des DockingStations
		for (int k = 0; k <numberOfDockingStation; k++) {
			ArrayList<ParkingSlot> parkingSlotList = new ArrayList<ParkingSlot>();
			for (int i = 0; i <numberOfParkingSlotByStation; i++) {
				parkingSlotList.add(new ParkingSlot());
			}
			DockingStationBalance dockingStationBalance = new DockingStationBalance();
			Coordinates dockingStationCoordinates = new Coordinates(Math.random()*10,Math.random()*10);
			String dockingStationType = null;
			if(k>=(int)Math.round(plusStationProportion*numberOfDockingStation)) {dockingStationType ="plus";}
			DockingStation dockingStation = new DockingStation(dockingStationCoordinates,"online",dockingStationType,numberOfParkingSlotByStation,parkingSlotList,dockingStationBalance);
			stationList.add(dockingStation);
		}
		//Création des bicycles et remplissage des Stations
		int numberOfBicycles =(int)Math.round(initialPopulationProportion*numberOfDockingStation*numberOfParkingSlotByStation);
		int numberOfMecanicalBicycles = (int)Math.round(mecanicalBicycleProportion*numberOfBicycles);
		int numberOfElectricalBicycles = numberOfBicycles-numberOfMecanicalBicycles;
		
		
		//On rempli en partant du début pour les mecanical
		for( int k = 0 ; k<numberOfMecanicalBicycles; k++) {
			DockingStation dockingstation = stationList.get(k%numberOfDockingStation);
			ParkingSlot parkingSlot = dockingstation.parkingSlotList.get(k/numberOfDockingStation);
			Bicycle bicycle = new Bicycle(dockingstation.getCoordinatesStation(), "mecanical");
			parkingSlot.addBicycle(bicycle, dockingstation);
			bicycleList.add(bicycle);
		}
		//Pour les electrical on part de la fin
		
		for( int k= 0; k<numberOfElectricalBicycles; k++) {
			DockingStation dockingstation = stationList.get(numberOfDockingStation-k%numberOfDockingStation-1);
			ParkingSlot parkingSlot = dockingstation.parkingSlotList.get(numberOfParkingSlotByStation-k/numberOfDockingStation-1);
			Bicycle bicycle = new Bicycle(dockingstation.getCoordinatesStation(), "electrical");
			parkingSlot.addBicycle(bicycle, dockingstation);
			bicycleList.add(bicycle);
		}
			
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
		return "Report on the actual state of the system \n Here are the bicycles :" + bicycleList + "\n Here are the Users :" + userList + "\n Here are the Stations :" + stationList
				+ "\n Here are the Rides :" + rideList;
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
