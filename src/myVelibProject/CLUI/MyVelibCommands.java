package myVelibProject.CLUI;

import java.util.ArrayList;

import myVelibProject.*;


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
					throw new GeneralException("Warning : This function is not implemented yet");



				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("User has not been added to the system\n\n");
			}
			break;

		case "online":
			try {
				// online <stationID>
				if (arguments.size() == 1) {
					throw new GeneralException("Warning : This function is not implemented yet");


				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("User has not been added to the system\n\n");
			}
			break;

		case "rentBike":
			try {
				// rentBike <userID> <depart> (depart : Coordinates ou int)
				if (arguments.size() == 2) {
					throw new GeneralException("Warning : This function is not implemented yet");


				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("User has not been added to the system\n\n");
			}
			break;

		case "returnBike":
			try {
				// return <userID> <arrivée> <duration> (arrivée : Coordinates ou int(stationID))
				if (arguments.size() == 3) {
					throw new GeneralException("Warning : This function is not implemented yet");


				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("User has not been added to the system\n\n");
			}
			break;

		case "displayStation":
			try {
				// displayStation <stationID>
				if (arguments.size() == 1) {
					throw new GeneralException("Warning : This function is not implemented yet");


				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("User has not been added to the system\n\n");
			}
			break;

		case "displayUser":
			try {
				// displayUser <userID>
				if (arguments.size() == 1) {
					throw new GeneralException("Warning : This function is not implemented yet");


				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("User has not been added to the system\n\n");
			}
			break;

		case "sortStation":
			try {
				// sortStation <sortPolicy>
				if (arguments.size() == 1) {
					throw new GeneralException("Warning : This function is not implemented yet");


				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("User has not been added to the system\n\n");
			}
			break;

		case "display":
			try {
				// display <>
				if (arguments.size() == 0) {
					throw new GeneralException("Warning : This function is not implemented yet");


				}
				else {throw new GeneralException("Warning : Wrong argument size");}



			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("User has not been added to the system\n\n");
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
