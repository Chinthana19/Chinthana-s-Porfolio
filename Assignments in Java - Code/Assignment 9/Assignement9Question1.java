/*
*   Assignement 9, Question 1: This is a main method to test fileUtils class
*   Author: Chinthana Sembakutti
*   Date: April 8, 2022
*/
package assignement9;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author chint
 */
public class Assignement9Question1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileUtils fileutil = new FileUtils();
        Scanner input = new Scanner(System.in);

        //using length method
        System.out.print("Enter folder path to find size: ");
        String pathSize = input.nextLine();
        int size = fileutil.length(pathSize);
        System.out.println("Size: " + size + " bytes");
        
        //using createRandomFile method
        System.out.print("\n\nCreating text file with random name: ");
        String location = fileutil.createRandomFile();
        System.out.println("File location: "+ location);
        
        //using split method
        System.out.print("Enter file path to text file to split: ");
        String pathSplit = input.nextLine();
        System.out.print("Enter number of lines each new file should be: ");
        int n = input.nextInt();
        fileutil.split(pathSplit, n);
        
        //using createDirectories method
        System.out.println("Creating directory using current year, month and date and folder names...");
        fileutil.createDirectories();        
    }

}
