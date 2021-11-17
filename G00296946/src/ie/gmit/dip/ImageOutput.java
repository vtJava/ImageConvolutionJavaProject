package ie.gmit.dip;

import java.io.File;
import java.util.Scanner;

/**
 * Handles the writer of an image after the image convolution class has
 * performed its method
 */

public class ImageOutput {
	private final static Scanner sn = new Scanner(System.in); // new Scanner object

	public static File getOutputPath() throws Exception { // get File method
		System.out.println("write in output file name here"); // show user input by string
		String extension = ".png"; // extension is png format
		String outputPath = sn.next().trim().toLowerCase() + extension; // trim whitespace with lowercase
		File op = new File(outputPath); // new File is the outputPath
		return op; // return File op as newly created file
	}

	public void finishScan() { // finish scanner method to close resource
		sn.close(); // close scanner
	}
}

/**   //This method works with ImageIO.write in ImageConvolution class .  */
 /* public static void main(String[] args) throws Exception { getOutputPath();
 * System.out.println("outputFile has been reached"); }
 */
