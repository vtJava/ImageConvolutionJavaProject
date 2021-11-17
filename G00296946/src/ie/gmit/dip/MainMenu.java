package ie.gmit.dip;

import java.util.Scanner;

public class MainMenu {
	
	private Scanner snr = new Scanner(System.in); // new scanner
	private InputFile inputfile;
	private boolean firstRunning = true; // boolean for menu to begin the menu

	protected InputFile getLocatefile() { // getter method to get file
		return inputfile;
	}

	protected void setLocatefile(InputFile inputfile) { // setter method
		this.inputfile = inputfile;
	}
	
	public void showOptions() {
		System.out.println("1) Enter Image Name"); //Ask user to specify the file to process. Do NOT hardcode paths or file names
		System.out.println("2) Select a Filter"); //List the set of filters evalaible in the class Kernel.java
		System.out.println("3) Additional Parameters Here...."); //Add as many options to the menu as you like and feel free to restructure it in any way.
		System.out.println("4) Quit"); //Restarts the menu to terminate the menu to start again
		System.out.println("\nSelect Option [1-4]>");
		
		System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
	}
	
	public void runFirstMenu() throws Exception { // start method to start the menu display
		showOptions(); // apply showMenu in this method
		while (firstRunning) { // keeps menu alive
			Integer choice = Integer.parseInt(snr.next()); // replaced with parseInt for consistent user design
			switch (choice) { // switch based on scanner input
			case 1:
				getFileDir(); // file check exists
				break;
			case 2:
				runSecondMenu(); //run menu with kernels available
				break;
			case 3:
				//TODO parameters multiplication factor & bias. Could include brightness of image
				//Could include the new Kernel here
				break;
			case 4:
				quit();
				break;
			default: // equivalent of else statement
				firstRunning = false; // breaks out of the menu
				System.out.println("menu has ended");
				System.out.println("[Error] Invalid input.");
				System.out.println("Filter Applied... Proceeding... Now Save your Filtered Image.");
				break; // added in break statement here to validate menu method and image convo class
			}
		}
		snr.close(); // closed the scanner
	}
	
	private void getFileDir() throws Exception { // this method here serves a boolean-find purpose only
		InputFile.getFile(); // method getFile from the LocateFile class
		System.out.println("menu has completed the boolean file check, File exists"); // validation
	}
	private void runSecondMenu() throws Exception {
		FilterMenu fm = new FilterMenu();
		fm.runFilterMenu(); //run the menu that contains kernels
	}

	private void quit() throws Exception {
			do {
				runFirstMenu(); // restart the menu by start() method again
			} while (firstRunning = true);
			System.out.println("Menu successfully restarted");
		}
}
