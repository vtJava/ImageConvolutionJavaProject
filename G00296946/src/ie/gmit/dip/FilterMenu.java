package ie.gmit.dip;

import java.util.Scanner;

/**
 * Handles the Menu operation to keep the menu alive Case statements replaced
 * the else if statements Kernel kernel = Kernel.LAPLACIAN example of
 * instantiating the enum specifically inside a menu method
 */

public class FilterMenu { // this class displays menu options

	protected ImageConvolution getIcv() { // getter method
		return icv;
	}

	protected void setIcv(ImageConvolution icv) { // setter method
		this.icv = icv;
	}

	private boolean secondRunning = true; // boolean for menu to begin the menu
	private Scanner sc = new Scanner(System.in); // new scanner
	private String userPath; // userPath parameter
	private InputFile locatefile; // instance of locateFile in ImageConvolution constructor
	private ImageConvolution icv = new ImageConvolution(locatefile); // instance of Image convolution class

	public void showFilterMenu() {
		System.out.println(ConsoleColour.RED); // colour of the outline in cmd
		System.out.println("Invalid selection!");
		System.out.println(ConsoleColour.RESET);
		System.out.println("[INFO] Select the Filter to apply");
		System.out.println("1)Laplacian: Select 2 on keyboard");
		System.out.println("2)EDGE_DETECTION_1: Select 3 on keyboard");
		System.out.println("3)BOX_BLUR: Select 4 on keyboard");
		System.out.println("4)SHARPEN: Select 5 on keyboard");
		System.out.println("5) EDGE_DETECTION_2: Select 6 on keyboard");
		System.out.println("6) VERTICAL_LINES: Select 7 on keyboard");
		System.out.println("7) HORIZONTAL_LINES: Select 8 on keyboard");
		System.out.println("8) DIAGONAL_45_LINES : Select 9 on keyboard");
		System.out.println("9) SOBEL_VERTICAL : Select 10 on keyboard");
		System.out.println("10) SOBEL_HORIZONTAL : Select 11 on keyboard");
		//forgot the Identity filter to filter the image by its own only.
		System.out.println("11) Restart the secondary select 12 number key");  //restart FilterMenu 
		System.out.println("12) Go back to primary menu select key number 13"); //restart main menu
	}

	public void runFilterMenu() throws Exception { // start method to start the menu display
		showFilterMenu(); // apply showMenu in this method
		while (secondRunning) { // keeps menu alive
			Integer selection = Integer.parseInt(sc.next()); // replaced with parseInt for consistent user design
			switch (selection) { // switch based on scanner input
			case 1:
				laplacian(); // laplacian
				break;
			case 2:
				edgeDetection1(); // edgedetection1
				break;
			case 3:
				boxBlur(); // boxblur
				break;
			case 4:
				sharpen(); // sharpen
				break;
			case 5:
				edgeDetection2();// edgedetection2
				break;
			case 6:
				verticalLines(); // verticallines
				break;
			case 7:
				horizontaLines(); // horizontaLines
				break;
			case 8:
				diagonal45lines(); // Diagonal lines
				break;
			case 9:
				sobelVertical(); // sobelVertical
				break;
			case 10:
				sobelHorizontal(); // sobelHorizontal
				break;
			case 11:
				restartMenu(); // restart menu
				break;
			case 12: 
				goBackFirstMenu();
				break;
			default: // equivalent of else statement
				secondRunning = false; // breaks out of the menu
				System.out.println("menu has ended");
				System.out.println("[Error] Invalid input.");
				System.out.println("Filter Applied... Proceeding... Now Save your Filtered Image.");
				break; // added in break statement here to validate menu method and image convo class
			}
		}
		sc.close(); // closed the scanner
	}


	private void goBackFirstMenu() throws Exception {
		do {
			MainMenu mm = new MainMenu();
			mm.runFirstMenu(); // restart the menu by start() method again
		} while (secondRunning = true);
		System.out.println("Go back to original menu");		
	}

	private void restartMenu() throws Exception {
		do {
			runFilterMenu(); // restart the menu by start() method again
		} while (secondRunning = true);
		System.out.println("Menu successfully restarted");
	}

	private void sobelHorizontal() throws Exception {
		Kernel kernel = Kernel.SOBEL_HORIZONTAL; // instance of SOBEL_HORIZONTAL kernel
		icv.convolve(kernel, userPath); // call the convolve method
		System.out.println("SOBEL_HORIZONTAL filter has been applied"); // validate
	}

	private void sobelVertical() throws Exception {
		Kernel kernel = Kernel.SOBEL_VERTICAL; // instance of SOBEL_VERTICAL kernel
		icv.convolve(kernel, userPath); // call the convolve method
		System.out.println("SOBEL_VERTICAL filter has been applied"); // validate
	}

	private void diagonal45lines() throws Exception {
		Kernel kernel = Kernel.DIAGONAL_45_LINES; // instance of DIAGONAL_45_LINES kernel
		icv.convolve(kernel, userPath); // call the convolve method
		System.out.println("DIAGONAL_45_LINES filter has been applied"); // validate
	}

	private void horizontaLines() throws Exception {
		Kernel kernel = Kernel.HORIZONTAL_LINES; // instance of HORIZONTAL_LINES kernel
		// insert into kernel variable
		icv.convolve(kernel, userPath); // call the convolve method
		System.out.println("HORIZONTAL_LINES filter has been applied"); // validate
	}

	private void verticalLines() throws Exception {
		Kernel kernel = Kernel.VERTICAL_LINES; // instance of VERTICAL_LINES kernel
		icv.convolve(kernel, userPath); // call the convolve method
		System.out.println("VERTICAL_LINES filter has been applied"); // validate
	}

	private void edgeDetection2() throws Exception {
		Kernel kernel = Kernel.EDGE_DETECTION_2; // instance of edgedetection2 kernel
		icv.convolve(kernel, userPath); // call the convolve method
		System.out.println("edgeDetection2 filter has been applied"); // validate
	}

	private void sharpen() throws Exception {
		Kernel kernel = Kernel.SHARPEN; // instance of sharpen kernel
		icv.convolve(kernel, userPath); // call the convolve method
		System.out.println("Sharpen filter has been applied"); // validate

	}

	private void boxBlur() throws Exception {
		Kernel kernel = Kernel.BOX_BLUR; // instance of boxblur kernel
		icv.convolve(kernel, userPath); // call the convolve method
		System.out.println("Boxblur filter has been applied"); // validate
	}

	private void edgeDetection1() throws Exception {
		Kernel kernel = Kernel.EDGE_DETECTION_1; // instance of edgedetection1 kernel
		icv.convolve(kernel, userPath); // run convolve
		System.out.println("edgeDetection1 filter has been applied"); // validate
	}

	private void laplacian() throws Exception {
		Kernel kernel = Kernel.LAPLACIAN; // instance of laplacian kernel
		icv.convolve(kernel, userPath); // run convolve()
		System.out.println("Laplacian filter has been applied"); // validate
	} // end of method
} // end of class


//case 13:
//	closeMenu(); // close menu
//	break;
/*	private void closeMenu() { //manual method to close the menu
	do {
		secondRunning = false;  //change keepRunning boolean manually in menu
	} while (secondRunning = true); // loop keeps going if true so if close Menu is selected resource can be closed
	System.out.println("Menu is shutdown, please restart cmd program");
}  */
