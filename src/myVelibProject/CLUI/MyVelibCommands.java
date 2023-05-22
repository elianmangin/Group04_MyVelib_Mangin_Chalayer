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
			int nstations = (int) Double.parseDouble(arguments.get(0));
			int nslots = (int) Double.parseDouble(arguments.get(1));
			double s = Double.parseDouble(arguments.get(2));
			int nbikes = (int) Double.parseDouble(arguments.get(3));
			
			double initialProportion = ((double) nbikes)/((double)(nstations*nslots));
			
			try {
				MyVelibSystem.myVelib = new MyVelib(nstations, nslots, initialProportion, 0.7, 0.5, s);
			} catch (GeneralException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		case "addUser":
			
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
