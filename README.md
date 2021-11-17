# ImageConvolutionJava
Project in applying 3x3 filters over an image

G00296946 Valery Taustsiakou ReadMe.txt File of Image Filtering 2D Application:
The main referenece applied was Tech.abdulfatir.com
Operating system is Windows 10. 
Eclipse Version used: Version Jdk 15
This program works as a command line application. 

Overview of the app design:
The application works is built with a primary menu and a larger filterMenu of kernels.
 
Both ImageInput & ImageOutput classes are set up to specifically target PNG format files 
by embedding the String ".PNG" inside these classes for simplicity.
Therefore, no need to write in .png by the user. 

The ImageIO.read utility is used within general pixalation purpose ImageConvolution class to draw
in the getFile method from InputFile class. 
The ImageIO.write utility is used within ImageConvolution class to draw in getOutputPath() method from
ImageOutput class to output a file. This was performed to flow in the image object into ImageIO 
.write to get the object processed into a file output.

The enums are ConsoleColour & Kernel java files. The enum Kernel is embedded into the ImageConvolution
class as a parameter & into the nested for Kernel for-loops to run the method as a general enumarator 
method.
The Kernels are specifically instantiated inside the Menu class method's per Kernel object. The
convolve() method is called each time with parameter kernel inside the Menu class per filter.

Each Menu class has a header method to display the menu. The boolean keepRunning=true
keeps the menu on. The switch statements each have a break statement to terminate the menu.
The default statement is like an else statement to reset the keepRunnin to true. 
A restart menu option is included in the menu options to end the menu.

The Runner class runs the runHeader() method to show the project name and directory path of 
the current project folder. The Runner class main() then calls the Menu class start() method.

How to use the app:  
The option 1 is for a boolean check if the file exists or not using a while loop.
Any of the filter options ask for file input e.g. write in:  gmitrgb 
because command line tool cmd runs from src folder containing the png file images.
Menu then asks for a file output e.g. write in ie/output/filename to direct the output file to ie/output folder.
(leave out .png due to app design). 
Inside the eclipse software the loading of files is from the project root folder. 

Each filter method is built in with its own image input & output selection due to the 
design of the application. It was attempted to reduce this redundancy in the application but 
ImageIO utility is more effective inside one class. 

MLA style References:
Kernel Image Processing : Image Filters (with Java Code)
http://tech.abdulfatir.com/2014/05/kernel-image-processing.html?m=0

Java - get pixel array from image
https://stackoverflow.com/questions/6524196/java-get-pixel-array-from-image/9470843#9470843

 
Image processing: convolution matrices in Java
https://gist.github.com/RaffaeleSgarro/90143c942847a1dd08fa

 
image-filters/imageFilters at master · gbaudic/image-filters
https://github.com/gbaudic/image-filters/tree/master/imageFilters
