package myVelibProject.system.core;

import java.util.ArrayList;
import java.util.Collections;

public class MyVelib {
	protected ArrayList<Bicycle> bicycleList;
	protected ArrayList<User> userList;
	protected ArrayList<DockingStation> stationList;
	public Renter renter = new Renter(this);

	public MyVelib(int numberOfDockingStation, int numberOfParkingSlotByStation, double initialPopulationProportion,double mecanicalBicycleProportion,double plusStationProportion,double s) throws GeneralException {
		super();
		bicycleList = new ArrayList<Bicycle>();
		userList = new ArrayList<User>();
		stationList = new ArrayList<DockingStation>();
		User.setIdCounterUser(0);
		DockingStation.setIdCounterStation(0);
		Bicycle.setIdCounterBicycle(0);

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
		ComparatorByLeastOccupiedStation comparatorByLeastOccupiedStation = new ComparatorByLeastOccupiedStation();
		Collections.sort(this.stationList,comparatorByLeastOccupiedStation);
	}
	
	public void SortByIDStation(){
		ComparatorByIDStation comparatorByIDStation = new ComparatorByIDStation();
		Collections.sort(this.stationList,comparatorByIDStation);
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

	public void report() {
		System.out.print("\nOnline Stations : ");
		for (DockingStation DS : stationList) {
			if (DS.status == "online") {
				System.out.print("\nDockingStation number "+DS.getUniqID() );
			}
		}
		System.out.print("\nOffline Stations : ");
		for (DockingStation DS : stationList) {
			if (DS.status == "offline") {
				System.out.print("\nDockingStation number "+DS.getUniqID());
			}
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
	
	public boolean setOfflineStation(int ID) throws GeneralException {
		for (DockingStation S : stationList) {
			if (S.getUniqID()==ID) {
				if (S.getStatus().equals("online")) {
					S.setStatus("offline");
					return true;
				}
				else if(S.getStatus().equals("offline")) {
					throw new GeneralException("Station already offline");
				}
				
				else {
					S.setStatus("offline");
					System.out.println("Warning : Current station's status doesn't correspond to any known status");
				}
				
			}
		}
		throw new GeneralException("No station found with this ID");
		
	}
	
	public boolean setOnlineStation(int ID) throws GeneralException {
		for (DockingStation S : stationList) {
			if (S.getUniqID()==ID) {
				if (S.getStatus().equals("offline")) {
					S.setStatus("online");
					return true;
				}
				else if(S.getStatus().equals("online")) {
					throw new GeneralException("Station already online");
				}
				
				else {
					S.setStatus("offline");
					System.out.println("Warning : Current station's status doesn't correspond to any known status");
				}
				
			}
		}
		throw new GeneralException("No station found with this ID");
		
	}


	// Getters, Setters, toString
	@Override
	public String toString() {
		return "\u001B[32mReport on the actual state of the system\u001B[0m \n\u001B[32mHere are the bicycles :\u001B[0m" + bicycleList + "\n\u001B[32mHere are the Users :\u001B[0m" + userList + "\n\u001B[32mHere are the Stations :\u001B[0m" + stationList;
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
