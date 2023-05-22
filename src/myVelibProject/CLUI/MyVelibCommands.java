package myVelibProject.CLUI;

import java.util.ArrayList;

import myVelibProject.GeneralException;
import myVelibProject.MyVelib;

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
			int nstations = Integer.parseInt(arguments.get(0));
			int nslots = Integer.parseInt(arguments.get(1));
			double s = Double.parseDouble(arguments.get(2));
			int nbikes = Integer.parseInt(arguments.get(3));
			
			double initialProportion = ((double) nbikes)/((double)(nstations*nslots));
			
			try {
				if (nbikes>nstations*nslots) {throw new GeneralException("Warning : more bicycle than slots");}
				MyVelibSystem.myVelib = new MyVelib(nstations, nslots, initialProportion, 0.7, 0.5, s);
				System.out.println("MyVelib set with "+ MyVelibSystem.myVelib.getStationList().size()
						+" station, "+MyVelibSystem.myVelib.getStationList().get(0).getNumberOfSlots()
						+" slots per station and "+MyVelibSystem.myVelib.getBicycleList().size()
						+" bicycles in a square with a side of "+s+"\n\n");
			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.out.println("MyVelib has not been set\n\n");
			}
		
		case "addUser":
			int userID = Integer.parseInt(arguments.get(0));
			
		case "offline":
			
		case "online":
			
		case "rentBike":
		
		case "returnBike":
		
		case "displayStation":
		
		case "displayUser":
			
		case "sortStation":
			
		case "display":
		}

	}



}
