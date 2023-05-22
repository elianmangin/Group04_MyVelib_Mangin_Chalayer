package Group04_Velib_Mangin_Chalayer.system;

import java.util.ArrayList;
import java.util.Collections;

public class MyVelib {
	protected ArrayList<Bicycle> bicycleList;
	protected ArrayList<User> userList;
	protected ArrayList<DockingStation> stationList;
	protected Renter renter = new Renter(this);

	public MyVelib(int numberOfDockingStation, int numberOfParkingSlotByStation, double initialPopulationProportion,double mecanicalBicycleProportion,double plusStationProportion,double s) throws GeneralException {
		super();
		bicycleList = new ArrayList<Bicycle>();
		userList = new ArrayList<User>();
		stationList = new ArrayList<DockingStation>();

		//Création des DockingStations

		for (int k = 0; k <numberOfDockingStation; k++) {
			Coordinates dockingStationCoordinates = new Coordinates(Math.random()*s,Math.random()*s);

			String dockingStationType = null;
			if(k>=(int)Math.round(plusStationProportion*numberOfDockingStation)) {dockingStationType ="plus";}

			DockingStation dockingStation = new DockingStation(dockingStationCoordinates,dockingStationType,numberOfParkingSlotByStation);
			stationList.add(dockingStation);
		}


		//Création des bicycles et remplissage des Stations

		int numberOfBicycles =(int)Math.round(initialPopulationProportion*numberOfDockingStation*numberOfParkingSlotByStation);
		int numberOfMecanicalBicycles = (int)Math.round(mecanicalBicycleProportion*numberOfBicycles);
		int numberOfElectricalBicycles = numberOfBicycles-numberOfMecanicalBicycles;


		//On rempli en partant du début pour les mecanical

		for( int k = 0 ; k<numberOfMecanicalBicycles; k++) {

			DockingStation dockingStation = stationList.get(k%numberOfDockingStation);
			Bicycle bicycle = new Bicycle(dockingStation.getGps(), "mecanical");
			dockingStation.addBicycle(bicycle);
			bicycleList.add(bicycle);

		}


		//Pour les electrical on part de la fin

		for( int k= 0; k<numberOfElectricalBicycles; k++) {
			DockingStation dockingStation = stationList.get(numberOfDockingStation-k%numberOfDockingStation-1);
			Bicycle bicycle = new Bicycle(dockingStation.getGps(), "electrical");
			dockingStation.addBicycle(bicycle);
			bicycleList.add(bicycle);
		}

	}

	public void addBicycle(Bicycle bicycle) {
		bicycleList.add(bicycle);
	}
	public void addDockingStation(DockingStation dockingStation) {
		stationList.add(dockingStation);
	}

	public void addUser(User user) {
		userList.add(user);
	}

	public void SortByMostUsedStation(){
		ComparatorByMostUsedStation comparatorByMostUsedStation = new ComparatorByMostUsedStation();
		Collections.sort(this.stationList,comparatorByMostUsedStation);
	}

	public void SortByLeastOccupiedStation(){
		ComparatorByLeastOccupiedStation comparatorByMostUsedStation = new ComparatorByLeastOccupiedStation();
		Collections.sort(this.stationList,comparatorByMostUsedStation);
	}

	public void displayStations() {
		for (DockingStation DS : stationList) {
			System.out.println(DS);
		}
	}

	public void displayBicycles() {
		for (Bicycle B : bicycleList) {
			System.out.println(B);
		}
	}

	public void displayUsers() {
		for (User U : userList) {
			System.out.println(U);
		}
	}

	
	public User getUserFromID(int ID) throws GeneralException {
		for (User U : userList) {
			if (U.getUniqID()==ID) {return U;}
		}
		throw new GeneralException("No user found with this ID");
	}
	
	public Bicycle getBicycleFromID(int ID) throws GeneralException {
		for (Bicycle B : bicycleList) {
			if (B.getUniqID()==ID) {return B;}
		}
		throw new GeneralException("No bicycle found with this ID");
	}
	
	public DockingStation getStationFromID(int ID) throws GeneralException {
		for (DockingStation S : stationList) {
			if (S.getUniqID()==ID) {return S;}
		}
		throw new GeneralException("No station found with this ID");
	}


	// Getters, Setters, toString
	@Override
	public String toString() {
		return "Report on the actual state of the system \n Here are the bicycles :" + bicycleList + "\n Here are the Users :" + userList + "\n Here are the Stations :" + stationList;
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



}
