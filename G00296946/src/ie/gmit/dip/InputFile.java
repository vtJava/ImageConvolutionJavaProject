package ie.gmit.dip;

import java.io.File;
import java.util.Scanner;

/**
 * Handles the image file input by scanner ImageIO is performed in
 * ImageConvolution using this method
 */

public class InputFile {

	private final static Scanner sncr = new Scanner(System.in); // new Scanner object

	public static File getFile() throws Exception { // get File method
		System.out.println("write in file name here"); // show user input by string
		String extension = ".png"; // extension is png format
		String userPath = sncr.next().trim().toLowerCase() + extension; // trim whitespace with lowercase
		File f = new File(userPath); // ln breakpointw was here for some reason.Double clicked it.

		while (f.exists()) { // if statement
			System.out.println("File exists"); // test the method with print line
			System.out.println(f);
			break;
		} // breaks the while loop
		if (!f.exists()) {
			System.out.println(userPath + " doesn't exist! Please specify a valid filename.");
			userPath = sncr.next(); // keep asking user to write in file again
		}
		System.out.println(userPath); //print the userPath to test
		return f;  //return file f
	}

	public void endScan() { // finish scanner method to close resource
		sncr.close(); // close scanner
	}
}


/* public static void main(String[] args) throws Exception {  //Tester method for this class
getFile(); //run method
}*/

