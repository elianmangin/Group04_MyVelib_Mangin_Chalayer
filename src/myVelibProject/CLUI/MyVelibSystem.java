package myVelibProject.CLUI;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.ini4j.*;

import myVelibProject.*;

public class MyVelibSystem {
	public static MyVelib myVelib;

	public static void main(String[] args) {
		initialization();
		
		commandLoop();
		
		endProcess();
		
	}

	private static void initialization() {
		// Code for Loading my_velib.ini
		try{
			Wini ini = new Wini(new File("src/myVelibProject/CLUI/tests/myVelib.ini"));


			String nstations = ini.get("stations", "nstations", String.class);
			String nslots = ini.get("stations", "nslots", String.class);
			String s = ini.get("stations", "s", String.class);
			String nbikes = ini.get("stations", "nbikes", String.class);

			
			
			String namesString = ini.get("users", "names", String.class);
			ArrayList<String> names = new ArrayList<String>(Arrays.asList(namesString.split(",")));
			String xString = ini.get("users", "x", String.class);
			ArrayList<String> x = new ArrayList<String>(Arrays.asList(xString.split(",")));
			String yString = ini.get("users", "y", String.class);
			ArrayList<String> y = new ArrayList<String>(Arrays.asList(yString.split(",")));
			String cardTypeString = ini.get("users", "cardType", String.class);
			ArrayList<String> cardTypes = new ArrayList<String>(Arrays.asList(cardTypeString.split(",")));
			String initBalanceString = ini.get("users", "initBalance", String.class);
			ArrayList<String> initBalances = new ArrayList<String>(Arrays.asList(initBalanceString.split(",")));
			
			

			
			ArrayList<String> arguments =  new ArrayList<String>();
			arguments.add(nstations);
			arguments.add(nslots);
			arguments.add(s);
			arguments.add(nbikes);
			
			
			MyVelibCommands myVelibSetup = new MyVelibCommands("setup", arguments);
			myVelibSetup.eval();

			
			
			for (int i = 0; i < names.size(); i++) {
				Coordinates userGps = new Coordinates(Double.parseDouble(x.get(i)),  Double.parseDouble(y.get(i)));
				User user;
				if (!cardTypes.get(i).equals("null")) {
					user = new User(names.get(i), userGps, cardTypes.get(i), Double.parseDouble(initBalances.get(i)));
				}
				else {
					user = new User(names.get(i), userGps, null, Double.parseDouble(initBalances.get(i)));
				}
				
				MyVelibSystem.myVelib.addUser(user);
			}

			
			
			System.out.print("Total number of user in the network: " + myVelib.getUserList().size() + "\n\n");
			
			


		}catch(Exception e){
			System.err.println(e.getMessage());

		}

	}
	
	private static void commandLoop() {
		try (Scanner scanner = new Scanner(System.in)) {
			String checkExit = "";
            while (checkExit != "exit") {
            	
            	System.out.println("Please enter a command : ");
                String commandInput = scanner.nextLine();
                checkExit = commandInput.intern();
                ArrayList<String> commandInputSplit = new ArrayList<String>(Arrays.asList(commandInput.split(" ")));
                
                String command = commandInputSplit.get(0);
                
                commandInputSplit.remove(0);
                
                ArrayList<String> arguments = commandInputSplit;
                
                MyVelibCommands myVelibLoop = new MyVelibCommands(command, arguments);
                myVelibLoop.eval();
                
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
	}
	
	private static void endProcess() {
		myVelib = null;
		System.out.println("You exited the system");
	}


}
