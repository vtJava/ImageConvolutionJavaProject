package ie.gmit.dip;

/**
 * Start the Menu in Runner class
 * 
 */

public class Runner {

	private static String colour;  //object

	public static void runHeader(String colour) {  //parameter enum colour
		System.out.println(ConsoleColour.BLUE_BRIGHT); // colour of the outline in cmd
		System.out.println("Invalid selection!");
		System.out.println(ConsoleColour.RESET);
		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*           Image Filtering System V0.1           *");
		System.out.println("*     H.Dip in Science (Software Development)     *");
		System.out.println("*                                                 *");
		System.out.println("***************************************************");
		System.out.println(ConsoleColour.RESET);
		// displays the path for current project
		System.out.println("Present Project Directory : " + System.getProperty("user.dir"));
	}

	public static void main(String[] args) throws Exception { // main()

		runHeader(colour);  //run instance of enum colour in main using enum parameter colour 
		
		MainMenu mm = new MainMenu();   
		mm.runFirstMenu(); //run instance of primary menu
		
	} // end of main()
} // end of class


/**
 * Access Filters Method: double[][] kernel = Kernel.SOBEL_HORIZONTAL;
 * 
 * //You can refer to them directly like this: for (int row = 0; row <
 * Kernel.SOBEL_HORIZONTAL.length; row++){ for (int col = 0; col <
 * Kernel.SOBEL_HORIZONTAL[row].length; col++){
 * System.out.println(Kernel.SOBEL_HORIZONTAL[row][col]); } }
 */

/**    //Ran out of time to apply multiplication factor and bias as additional parameters.
 *		
 * System.out.println("1) Enter Image Name"); //Ask user to specify the file to
 * process. Do NOT hardcode paths or file names System.out.println("2) Select a
 * Filter"); //List the set of filters evalaible in the class Kernel.java
 * System.out.println("3) Additional Parameters Here...."); //Add as many
 * options to the menu as you like and feel free to restructure it in any way.
 * System.out.println("4) Quit"); //Terminate System.out.println("\nSelect
 * Option [1-4]>");
 */