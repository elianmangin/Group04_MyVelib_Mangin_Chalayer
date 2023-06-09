package system.core;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class defines the characteristics of the myVelib system.
 * <p>
 * It is composed of the bicycle list, the station list, the user list and a renter.
 * @see Renter
 * </p>
 */
public class MyVelib {
	protected ArrayList<Bicycle> bicycleList;
	protected ArrayList<User> userList;
	protected ArrayList<DockingStation> stationList;
	public Renter renter = new Renter(this);
	
	/** Initialise the system with a given number of station, a given number of slot per station, a given proportion of the slot fill with bike (between 0 and 1),
	 * a given proportion of mecanical bicycle (the rest is electrical), a given proportion of plus station and a given size of the side of the square (area).*/
	public MyVelib(int numberOfDockingStation, int numberOfParkingSlotByStation, double initialPopulationProportion,double mecanicalBicycleProportion,double plusStationProportion,double s) throws GeneralException {
		super();
		bicycleList = new ArrayList<>();
		userList = new ArrayList<>();
		stationList = new ArrayList<>();
		User.setIdCounterUser(0);
		DockingStation.setIdCounterStation(0);
		Bicycle.setIdCounterBicycle(0);

		//Création des DockingStations

		for (int k = 0; k <numberOfDockingStation; k++) {
			Coordinates dockingStationCoordinates = new Coordinates(Math.random()*s,Math.random()*s);

			String dockingStationType = null;
			if(k<(int)Math.round(plusStationProportion*numberOfDockingStation)) {dockingStationType ="plus";}

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
	
	/** Add a bicycle to the system.*/
	public void addBicycle(Bicycle bicycle) {
		bicycleList.add(bicycle);
	}
	
	/** Add a station to the system.*/
	public void addDockingStation(DockingStation dockingStation) {
		stationList.add(dockingStation);
	}
	
	/** Add a user to the system.*/
	public void addUser(User user) {
		userList.add(user);
	}
	
	/** Sort station using ComparatorByMostUsedStation.*/
	public void SortByMostUsedStation(){
		ComparatorByMostUsedStation comparatorByMostUsedStation = new ComparatorByMostUsedStation();
		Collections.sort(this.stationList,comparatorByMostUsedStation);
	}
	
	/** Sort station using ComparatorByLeastUsedStation.*/
	public void SortByLeastOccupiedStation(){
		ComparatorByLeastOccupiedStation comparatorByLeastOccupiedStation = new ComparatorByLeastOccupiedStation();
		Collections.sort(this.stationList,comparatorByLeastOccupiedStation);
	}
	
	/** Sort station using ComparatorByIDStation.*/
	public void SortByIDStation(){
		ComparatorByIDStation comparatorByIDStation = new ComparatorByIDStation();
		Collections.sort(this.stationList,comparatorByIDStation);
	}
	
	/** Print the toString of each station of the system.*/
	public void displayStations() {
		for (DockingStation DS : stationList) {
			System.out.println(DS);
		}
	}
	
	/** Print the toString of each bicycle of the system.*/
	public void displayBicycles() {
		for (Bicycle B : bicycleList) {
			System.out.println(B);
		}
	}
	
	/** Print the toString of each user of the system.*/
	public void displayUsers() {
		for (User U : userList) {
			System.out.println(U);
		}
	}
	
	/** Print a report of the system (online stations with the list of bicycle parked inside,
	 *  offline stations with the list of bicycle parked inside and users).*/
	public void report() {
		System.out.print("\nOnline Stations : ");
		for (DockingStation DS : stationList) {
			if (DS.status == "online") {
				System.out.print("\n Station "+DS.getUniqID() + " , parked bicycles " +DS.getBicycleIDList() );
			}
		}
		System.out.print("\nOffline Stations : ");
		for (DockingStation DS : stationList) {
			if (DS.status == "offline") {
				System.out.print(" "+DS.getUniqID());
			}
		}
		System.out.print("\nUsers : ");
		for (User user : userList) {
			System.out.print(" "+user.getName()+ " (" + user.getUniqID() + ") " );
		}
	}
	
	/** Return the user assiociated to the given ID.*/
	public User getUserFromID(int ID) throws GeneralException {
		for (User U : userList) {
			if (U.getUniqID()==ID) {return U;}
		}
		throw new GeneralException("No user found with this ID");
	}
	
	/** Return the bicycle assiociated to the given ID.*/
	public Bicycle getBicycleFromID(int ID) throws GeneralException {
		for (Bicycle B : bicycleList) {
			if (B.getUniqID()==ID) {return B;}
		}
		throw new GeneralException("No bicycle found with this ID");
	}
	
	/** Return the station assiociated to the given ID.*/
	public DockingStation getStationFromID(int ID) throws GeneralException {
		for (DockingStation S : stationList) {
			if (S.getUniqID()==ID) {return S;}
		}
		throw new GeneralException("No station found with this ID");
	}
	
	/** Set the station with a given ID to offline.*/
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
	
	/** Set the station with a given ID to online.*/
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
	
	public void setStationList(ArrayList<DockingStation> stationList) {
		this.stationList = stationList;
	}



}
