package ie.gmit.dip;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
* Handles the convolution operation with a general enum of kernels
*/

/**
 * Task 1: Read each of the pixels from the BufferedImage into the same
 * row/column position in the double[][] array (reading pixels code is in
 * project spec).*
 * 
 * /* Task 2: Write each of the values in the double[][] array into the pixels
 * in the BufferedImage
 */

/**
 * Takes an image (grey-levels) and a kernel and a position, applies the
 * convolution at that position and returns the new pixel value.
 *
 * @param Kernel The 2D double array representing the Kernerl
 * @param String userPath The String userPath that is read in from the
 *               LocateImage class
 * @return The kernel parameter
 */

//	Tech.abdulfatir.com  citation

public class ImageConvolution {

	// private static String userPath; //used with main() in this class

	private final InputFile inputfile; // initialise variable from class LocateFile to use in constructor
	private final ImageOutput imageoutput; // initialise variable from class ImageOutput

	protected ImageConvolution(InputFile ainputfile) {
		super(); // constructor
		inputfile = ainputfile; // set constructor to replace the static reference in InputFile class
		this.imageoutput = new ImageOutput(); // initialise ImageOutput class object
	}

	public double[][] convolve(Kernel kernel, String userPath) throws Exception {
		// BufferedImage image = ImageIO.(new File("src/gmitgs.png")); //relative path
	
		BufferedImage image = ImageIO.read(InputFile.getFile()); // Image input of file by ImageIO

		// getting length and height of image
		int width = image.getWidth();
		int height = image.getHeight();

		for (int y = 0; y < image.getHeight(); y++) { // Loop over the 2D image across each pixel
			for (int x = 0; x < image.getWidth(); x++) {

				int pixel = image.getRGB(x, y); // Get the pixel at an (x, y) coordinate

				image.setRGB(x, y, pixel); // Set the pixel colour at (x, y) to red

				double alpha = 0d, red = 0d, green = 0d, blue = 0d; // initialise the colours at a zeroeth point
				
				// loop over the kernel
				for (int row = 0; row < kernel.getKernel()[0].length; row++) { // added in zeroe to start the array at
																				// 0,0 of row using the enum of kernel
					for (int col = 0; col < kernel.getKernel()[row].length; col++) { // the array starts off from the 0
																						// point of row aswell [row]

						int imageX = (x - (kernel.getKernel().length - 1) / 2 + row + width) % width; // container of
																										// image
						int imageY = (y - (kernel.getKernel().length - 1) / 2 + col + height) % height; 

						int RGB = image.getRGB(imageX, imageY);
						int A = (RGB >> 24) & 0xFF; // Bitshift 24 to get alpha value
						int R = (RGB >> 16) & 0xff; // Red Value
						int G = (RGB >> 8) & 0xff; // Green Value
						int B = (RGB) & 0xff; // Blue Value

						// The RGB is multiplied with current kernel element and added
						// on to the variables alpha, red, blue and green
						alpha += (A * kernel.getKernel()[row][col]);
						red += (R * kernel.getKernel()[row][col]);
						green += (G * kernel.getKernel()[row][col]);
						blue += (B * kernel.getKernel()[row][col]);
					}
				}
				@SuppressWarnings("unused")  //outA variable suppressed 
				int outA, outR, outG, outB;
				
				// The value is truncated to 0 and 255 values range of colour pixel data
				outA = Math.min(Math.max((int) (alpha), 0), 255);
				outR = Math.min(Math.max((int) (red), 0), 255);
				outG = Math.min(Math.max((int) (green), 0), 255);
				outB = Math.min(Math.max((int) (blue), 0), 255);
				// The new set pixel is written to the output image
				image.setRGB(x, y, new Color(outR, outG, outB).getRGB());
			}
		}
		// ImageIO.write(image, "png", new File("output/out6.png")); // writer method
		// code
		ImageIO.write(image, "png", (ImageOutput.getOutputPath())); // placed imagewriter class to use on image object
		return kernel.getKernel(); // returns kernel parameter to compile
	} // end convolve method

	protected InputFile getLocatefile() { // getter method get File to return image input
		return inputfile;
	}

	protected ImageOutput getImagewriter() { // getter method get Image Writer to return image output
		return imageoutput;
	}
} // end of class

/*
 * public static void main(String[] args) throws Exception { // Tester method
 * for this class ImageConvolution ic = new ImageConvolution(); Kernel kernel =
 * Kernel.EDGE_DETECTION_1; for (double[] d : ic.convolve(kernel, userPath)) {
 * //enhanced for loop to get the parameter in as kernel
 * System.out.println("reads here"); //outputs 3 times reads here } }
 */

/** 
 * int imageY = (y - (kernel.getKernel().length - 1) / 2 + col + height) % height; //code 
 *
 * Calculate x and y coordinates of the pixel that get multiplied by current
 * kernel element In case of edges of image the '% WIDTH' wraps the image to
 * prevent filter overflow of dimension 2D kernel.lenght/2 will give how much
 * the kernel over runs the edges like order 3 , kernel.lenght/2 =1 . So
 * starting at 0,0.The kernel Will over run to point -1,-1.
 */