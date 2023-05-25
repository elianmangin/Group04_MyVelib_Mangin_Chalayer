package Group04_MyVelib_Mangin_Chalayer.system.CLUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Group04_MyVelib_Mangin_Chalayer.system.core.Bicycle;
import Group04_MyVelib_Mangin_Chalayer.system.core.Coordinates;
import Group04_MyVelib_Mangin_Chalayer.system.core.DockingStation;
import Group04_MyVelib_Mangin_Chalayer.system.core.GeneralException;
import Group04_MyVelib_Mangin_Chalayer.system.core.MyVelib;
import Group04_MyVelib_Mangin_Chalayer.system.core.RideItinerary;
import Group04_MyVelib_Mangin_Chalayer.system.core.StationToStationItinerary;
import Group04_MyVelib_Mangin_Chalayer.system.core.StationToStreetItinerary;
import Group04_MyVelib_Mangin_Chalayer.system.core.StreetToStationItinerary;
import Group04_MyVelib_Mangin_Chalayer.system.core.User;


public class MyVelibCommands {
	private String command;
	private ArrayList<String> arguments;


	public MyVelibCommands(String command, ArrayList<String> arguments) {
		super();
		this.command = command;
		this.arguments = arguments;
	}


	public void eval() {
		// TODO Auto-generated method stub
		switch (command) {

		case "help":
			String help;
			help = "Here are the different commands that you can use on the myVelib system : \n\n"
					+"-  readScen <testScenario>\n"
					+ "Execute all the commands of testScenario.\n"
					+ "testScenario : name of a test in the 'eval' floder without .txt\n\n"

					+"-  setup <>\n"
					+ "Creates a myVelib network consisting of 10 stations each of which has\n"
					+ "10 parking slots and such that stations are arranged on a square grid whose of\n"
					+ "side 4km and initially populated with a 75% bikes randomly distributed over "
					+ "the 10 stations.\n\n"

					+ "-  setup <nstations> <nslots> <s> <nbikes>\n"
					+ "Creates a myVelib network consisting of nstations stations each of which has\n"
					+ "nslots parking slots and such that stations are arranged on a square grid whose of\n"
					+ "side s km and initially populated with a nbikes bikes randomly distributed over "
					+ "the stations.\n\n"

					+ "-  addUser <name> <cardType> <initBalance> <x> <y>\n"
					+ "-  addUser <firstName> <lastName> <cardType> <initBalance> <x> <y>\n"
					+ "Adds a user with a specified name, card type, credit balance, and initial\n"
					+ "position to the system.\n\n"

					+ "-  offline <stationID>\n"
					+ "Put a station status on offline.\n\n"

					+ "-  online <stationID>\n"
					+ "Put a station status on online.\n\n"

					+ "-  askPlanning <userID> <xDestination> <yDestination> <wantedTypeOfBicycle> <planning>\n"
					+ "Give the optimal start and the optimal end for a user wanting to go to (x,y) with a bicycle of\n"
					+ "a given type following a given ride planning\n"
					+ "planning : 'standard'\n\n"


					+ "-  rentBike <userID> <stationID> <type>\n"
					+ "A user rent a bicycle of a given type from a given station.\n"
					+ "They can also rent it from the street with rentBike <userID> <bikenID>\n\n"

					+ "-  returnBike <userID> <stationID> <duration>\n"
					+ "A user return their bike to a given station after a given time (in minutes).\n"
					+ "They can also let it in the street with returnBike <userID> <x> <y> <duration>\n\n"

					+ "-  displayStation <stationID>\n"
					+ "Display the station attributes and statistics.\n\n"

					+ "-  displayUser <userID>\n"
					+ "Display the users attributes and statistics.\n\n"

					+ "-  sortStation <sortPolicy>\n"
					+ "Sort the station with the specified sorting policy.\n"
					+ "sortPolicy : 'ID' / 'leastOccupied' / 'mostUsed'\n\n"

					+ "-  display <>\n"
					+ "Display the actual status of the whole system.\n\n";

			System.out.println(help);
			break;

		case "readScen":
			try {
				// online <stationID>
				if (arguments.size() == 1) {
					String testName = arguments.get(0);
					File testFile = new File("src/Group04_MyVelib_Mangin_Chalayer/eval/"+testName+".txt");

					try (Scanner scanner = new Scanner(testFile)) {
						while (scanner.hasNextLine()) {
							String commandInput = scanner.nextLine();
						    ArrayList<String> commandInputSplit = new ArrayList<>(Arrays.asList(commandInput.split(" ")));

						    String command = commandInputSplit.get(0);

						    commandInputSplit.remove(0);

						    ArrayList<String> arguments = commandInputSplit;

						    MyVelibCommands myVelibLoop = new MyVelibCommands(command, arguments);
						    myVelibLoop.eval();
						}
					}




				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("\u001B[33mStation status has not changed\u001B[0m\n\n");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			break;



		case "setup":
			try {
				int nstations;
				int nslots;
				double s;
				int nbikes;
				double initialProportion;

				// setup <>
				if (arguments.size()==0) {
					nstations = 10;
					nslots = 10;
					s = 4;
					initialProportion = 0.75;

				}
				// setup <nstations> <nslots> <s> <nbikes>
				else if (arguments.size() == 4) {

					nstations = Integer.parseInt(arguments.get(0));
					nslots = Integer.parseInt(arguments.get(1));
					s = Double.parseDouble(arguments.get(2));
					nbikes = Integer.parseInt(arguments.get(3));

					initialProportion = ((double) nbikes)/((double)(nstations*nslots));


					if (nbikes>nstations*nslots) {throw new GeneralException("Warning : more bicycle than slots");}

				}
				else {throw new GeneralException("Warning : Wrong argument size");}

				MyVelibSystem.myVelib = new MyVelib(nstations, nslots, initialProportion, 0.7, 0.5, s);
				System.out.println("\u001B[32mMyVelib set with "+ MyVelibSystem.myVelib.getStationList().size()
						+" station, "+MyVelibSystem.myVelib.getStationList().get(0).getNumberOfSlots()
						+" slots per station and "+MyVelibSystem.myVelib.getBicycleList().size()
						+" bicycles in a square with a side of "+s+"\u001B[0m\n\n");

			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("\u001B[33mMyVelib has not been set\u001B[0m\n\n");
			}
			break;

		case "addUser":
			try {
				String userName;
				String cardType;
				double initBalance;
				double initX;
				double initY;
				User user;
				// addUser <userName,cardType,initBalance,initX,initY>
				if (arguments.size() == 5) {
					userName = arguments.get(0);
					cardType = arguments.get(1);
					initBalance = Double.parseDouble(arguments.get(2));
					initX = Double.parseDouble(arguments.get(3));
					initY = Double.parseDouble(arguments.get(4));


				}
				// addUser <userFirstName,userLastName,cardType,initBalance,initX,initY>
				else if (arguments.size() == 6) {
					userName = arguments.get(0)+" "+arguments.get(1);
					cardType = arguments.get(2);
					initBalance = Double.parseDouble(arguments.get(3));
					initX = Double.parseDouble(arguments.get(4));
					initY = Double.parseDouble(arguments.get(5));

				}
				else {throw new GeneralException("Warning : Wrong argument size");}

				if (cardType.equals("none")) {cardType = null;}

				user = new User(userName, new Coordinates(initX, initY), cardType, initBalance);
				MyVelibSystem.myVelib.addUser(user);
				System.out.print("\u001B[32mSuccessfully added user to the system :\u001B[0m" + MyVelibSystem.myVelib.getUserList().get(MyVelibSystem.myVelib.getUserList().size()-1) + "\n\n");





			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("\u001B[33mUser has not been added to the system\u001B[0m\n\n");
			}
			break;

		case "offline":
			try {
				// offline <stationID>
				if (arguments.size() == 1) {
					int stationID = Integer.parseInt(arguments.get(0));
					MyVelibSystem.myVelib.setOfflineStation(stationID);
					System.out.println("\u001B[32mStation number "+stationID+" went offline\u001B[0m\n\n");

				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("\u001B[33mStation status has not changed\u001B[0m\n\n");
			}
			break;

		case "online":
			try {
				// online <stationID>
				if (arguments.size() == 1) {
					int stationID = Integer.parseInt(arguments.get(0));
					MyVelibSystem.myVelib.setOnlineStation(stationID);
					System.out.println("\u001B[32mStation number "+stationID+" went online\u001B[0m\n\n");


				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("\u001B[33mStation status has not changed\u001B[0m\n\n");
			}
			break;


		case "askPlanning":
			try {
				// askPlanning <userID> <xDestination> <yDestination> <wantedTypeOfBicycle> <planning>
				if (arguments.size() == 5) {
					int userID = Integer.parseInt(arguments.get(0));
					int x = Integer.parseInt(arguments.get(1));
					int y = Integer.parseInt(arguments.get(2));
					String wantedType = arguments.get(3);
					String planning = arguments.get(4);

					User user = MyVelibSystem.myVelib.getUserFromID(userID);

					MyVelibSystem.myVelib.renter.connectUser(user);
					MyVelibSystem.myVelib.renter.askPlanning(new Coordinates(x, y), wantedType, planning);
					RideItinerary itinerary = MyVelibSystem.myVelib.renter.getItinerary();

					System.out.println("\u001B[32mHere's the suggested itinerary :\u001B[0m");
					if (itinerary.getStart() instanceof Bicycle) {
						Bicycle B = (Bicycle) itinerary.getStart();
						System.out.println("\u001B[32mStart : Bicycle number "+B.getUniqID()+" located at "+B.getGps()+"\u001B[0m");
					}
					else if (itinerary.getStart() instanceof DockingStation) {
						DockingStation S = (DockingStation) itinerary.getStart();
						System.out.println("\u001B[32mStart : Station number "+S.getUniqID()+" located at "+S.getGps()+"\u001B[0m");
					}
					else {throw new GeneralException("Error : The type of start is unknown");}

					if (itinerary.getEnd() instanceof Coordinates) {
						Coordinates C = (Coordinates) itinerary.getEnd();
						System.out.println("\u001B[32mEnd : In the street "+C+"\u001B[0m\n\n");
					}
					else if (itinerary.getEnd() instanceof DockingStation) {
						DockingStation S = (DockingStation) itinerary.getEnd();
						System.out.println("\u001B[32mEnd : Station number "+S.getUniqID()+" located at "+S.getGps()+"\u001B[0m\n\n");
					}
					else {throw new GeneralException("Error : The type of end is unknown");}



				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("\u001B[33mStation status has not changed\u001B[0m\n\n");
			}
			break;

		case "rentBike":
			try {
				int userID = Integer.parseInt(arguments.get(0));
				User user = MyVelibSystem.myVelib.getUserFromID(userID);

				if (user.isCurrentlyRenting()) {throw new GeneralException(user.getName()+" is already renting a bike");}
				// rentBike <userID> <stationID> <type>
				if (arguments.size() == 3) {
					int stationID = Integer.parseInt(arguments.get(1));
					String type = arguments.get(2);
					DockingStation station = MyVelibSystem.myVelib.getStationFromID(stationID);
					MyVelibSystem.myVelib.renter.connectUser(user);
					MyVelibSystem.myVelib.renter.setItinerary(new StationToStationItinerary(station, null, type));
					int bikeID = MyVelibSystem.myVelib.renter.rentBicycle(LocalTime.of(0, 0));
					MyVelibSystem.myVelib.renter.disconnectUser();
					System.out.println("\u001B[32m"+user.getName()+" successfully took the "+MyVelibSystem.myVelib.getBicycleFromID(bikeID).getType()+" bike number "+bikeID+" from the station number "+stationID+"\u001B[0m\n\n");



				}
				// rentBike <userID> <bicycleID>
				else if(arguments.size() == 2) {
					int bikeID = Integer.parseInt(arguments.get(1));
					Bicycle bicycle = MyVelibSystem.myVelib.getBicycleFromID(bikeID);
					MyVelibSystem.myVelib.renter.connectUser(user);
					MyVelibSystem.myVelib.renter.setItinerary(new StreetToStationItinerary(bicycle, null, bicycle.getType()));
					MyVelibSystem.myVelib.renter.rentBicycle(LocalTime.of(0, 0));
					MyVelibSystem.myVelib.renter.disconnectUser();
					System.out.println("\u001B[32m"+user.getName()+" successfully took the bike number "+bikeID+" located at "+bicycle.getGps()+"\u001B[0m\n\n");

				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("\u001B[33mThe bike has not been rented\u001B[0m\n\n");
			}
			break;

		case "returnBike":
			try {
				int userID = Integer.parseInt(arguments.get(0));
				User user = MyVelibSystem.myVelib.getUserFromID(userID);

				if (!user.isCurrentlyRenting()) {throw new GeneralException(user.getName()+" is not renting a bike");}
				// return <userID> <idStation> <duration>
				if (arguments.size() == 3) {
					int stationID = Integer.parseInt(arguments.get(1));
					int duration = Integer.parseInt(arguments.get(2));
					int h = duration/60;
					int m = duration%60;
					DockingStation station = MyVelibSystem.myVelib.getStationFromID(stationID);
					MyVelibSystem.myVelib.renter.connectUser(user);
					MyVelibSystem.myVelib.renter.setItinerary(new StationToStationItinerary(null, station, null));
					MyVelibSystem.myVelib.renter.returnBicycle(LocalTime.of(h, m));
					MyVelibSystem.myVelib.renter.disconnectUser();
					System.out.println("\u001B[32m"+user.getName()+" successfully returned his bike to station number "+station.getUniqID()+" after "+h+" hours and "+m+" minutes "+"\u001B[0m\n\n");


				}
				// returnBike <userID> <x> <y> <duration>
				else if(arguments.size() == 4) {
					int x = Integer.parseInt(arguments.get(1));
					int y = Integer.parseInt(arguments.get(2));
					int duration = Integer.parseInt(arguments.get(3));
					int h = duration/60;
					int m = duration%60;
					Coordinates gps = new Coordinates(x,y);
					MyVelibSystem.myVelib.renter.connectUser(user);
					MyVelibSystem.myVelib.renter.setItinerary(new StationToStreetItinerary(null, gps, null));
					MyVelibSystem.myVelib.renter.returnBicycle(LocalTime.of(h, m));
					MyVelibSystem.myVelib.renter.disconnectUser();
					System.out.println("\u001B[32m"+user.getName()+" successfully parked his bike in the street ("+x+", "+y+") after "+h+" hours and "+m+" minutes "+"\u001B[0m\n\n");

				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("\u001B[33mThe bike has not been returned\u001B[0m\n\n");
			}
			break;

		case "displayStation":
			try {
				// displayStation <stationID>
				if (arguments.size() == 1) {
					int stationID = Integer.parseInt(arguments.get(0));
					System.out.println(MyVelibSystem.myVelib.getStationFromID(stationID)+"\n\n");



				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("\u001B[33mCan't display this station\u001B[0m\n\n");
			}
			break;

		case "displayUser":
			try {
				// displayUser <userID>
				if (arguments.size() == 1) {
					int userID = Integer.parseInt(arguments.get(0));
					System.out.println(MyVelibSystem.myVelib.getUserFromID(userID)+"\n\n");


				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("\\u001B[33mUser has not been added to the system\\u001B[0m\\n\\n");
			}
			break;

		case "sortStation":
			try {
				// sortStation <sortPolicy>
				if (arguments.size() == 1) {
					String sortPolicy = arguments.get(0);
					switch(sortPolicy) {
					case "ID":
						MyVelibSystem.myVelib.SortByIDStation();
						System.out.println("\u001B[32mStations have been sorted by ID\u001B[0m\n\n");
						break;

					case "leastOccupied":
						MyVelibSystem.myVelib.SortByLeastOccupiedStation();
						System.out.println("\u001B[32mStations have been sorted by least occupied\u001B[0m\n\n");
						break;

					case "mostUsed":
						MyVelibSystem.myVelib.SortByMostUsedStation();
						System.out.println("\u001B[32mStations have been sorted by most used\u001B[0m\n\n");
						break;

					default:
						throw new GeneralException("This sorting policy isn't handled by the system");

					}


				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("\\u001B[33mUser has not been added to the system\\u001B[0m\\n\\n");
			}
			break;

		case "display":
			try {
				// display <>
				if (arguments.size() == 0) {
					System.out.println(MyVelibSystem.myVelib);


				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("\\u001B[33mUser has not been added to the system\\u001B[0m\\n\\n");
			}
			break;

		default :
			try {
				throw new GeneralException("Warning : This command doesn't exist");

			} catch (GeneralException e) {
				System.err.println(e.getMessage());
			}
			break;

		}

	}



}
