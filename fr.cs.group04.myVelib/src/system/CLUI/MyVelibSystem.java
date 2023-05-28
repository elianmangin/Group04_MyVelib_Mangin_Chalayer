package system.CLUI;

import system.core.MyVelib;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.ini4j.*;

/**
 * The main for launching the CLUI.
 */
public class MyVelibSystem {
	public static MyVelib myVelib;
	
	/** Initialize the system with "eval.myVelib.ini" and wait for commands in the console with a loop.*/
	public static void main(String[] args) {
		startProcess();

		commandLoop();

	}
	
	/** Initialize the system with "eval.myVelib.ini".*/
	public static void startProcess() {
		// Code for Loading my_velib.ini
		try{
			Wini ini = new Wini(new File("src/eval/myVelib.ini"));


			String nstations = ini.get("stations", "nstations", String.class);
			String nslots = ini.get("stations", "nslots", String.class);
			String s = ini.get("stations", "s", String.class);
			String nbikes = ini.get("stations", "nbikes", String.class);



			String firstNamesString = ini.get("users", "firstNames", String.class);
			ArrayList<String> firstNames = new ArrayList<>(Arrays.asList(firstNamesString.split(",")));
			String lastNamesString = ini.get("users", "lastNames", String.class);
			ArrayList<String> lastNames = new ArrayList<>(Arrays.asList(lastNamesString.split(",")));
			String xString = ini.get("users", "x", String.class);
			ArrayList<String> x = new ArrayList<>(Arrays.asList(xString.split(",")));
			String yString = ini.get("users", "y", String.class);
			ArrayList<String> y = new ArrayList<>(Arrays.asList(yString.split(",")));
			String cardTypeString = ini.get("users", "cardType", String.class);
			ArrayList<String> cardTypes = new ArrayList<>(Arrays.asList(cardTypeString.split(",")));
			String initBalanceString = ini.get("users", "initBalance", String.class);
			ArrayList<String> initBalances = new ArrayList<>(Arrays.asList(initBalanceString.split(",")));




			ArrayList<String> arguments =  new ArrayList<>();
			arguments.add(nstations);
			arguments.add(nslots);
			arguments.add(s);
			arguments.add(nbikes);


			MyVelibCommands myVelibSetup = new MyVelibCommands("setup", arguments);
			myVelibSetup.eval();



			for (int i = 0; i < firstNames.size(); i++) {
				arguments =  new ArrayList<>();
				arguments.add(firstNames.get(i));
				arguments.add(lastNames.get(i));
				arguments.add(cardTypes.get(i));
				arguments.add(initBalances.get(i));
				arguments.add(x.get(i));
				arguments.add(y.get(i));

				myVelibSetup = new MyVelibCommands("addUser", arguments);
				myVelibSetup.eval();
			}

			System.out.println("\u001B[36mWelcome to the myVelib system CLUI !\nYou can use the 'help' command to see all the available commands.\n\u001B[0m");





		}catch(Exception e){
			System.err.println(e.getMessage());

		}

	}
	
	/** Wait for commands in the console with a loop.*/
	public static void commandLoop() {
		try(Scanner scanner = new Scanner(System.in)){
			while (true) {
				try {
					System.out.println("\u001B[36mPlease enter a command : \u001B[0m");
					System.out.print("> ");
					String commandInput = scanner.nextLine();
					ArrayList<String> commandInputSplit = new ArrayList<>(Arrays.asList(commandInput.split(" ")));

					String command = commandInputSplit.get(0);

					commandInputSplit.remove(0);

					ArrayList<String> arguments = commandInputSplit;

					MyVelibCommands myVelibLoop = new MyVelibCommands(command, arguments);
					myVelibLoop.eval();

				}catch (Exception e) {
					System.err.println("/!\\ Something went wrong /!\\\n"
							+ "Make sure you write a correct command.\n"
							+ "Please refer yourself to the help command if you have any doubt");
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}


}
