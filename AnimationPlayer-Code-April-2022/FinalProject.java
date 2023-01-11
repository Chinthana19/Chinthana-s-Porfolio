/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalprojectfinal;
import finalprojectfinal.FileReader2;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author chint
 */
public class FinalProject {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter file location: ");
        String filename = input.nextLine();
        
        //C:\Users\chint\University\University Of Guelph\1st Year\Semester 2\ENGG 1420 - Programming\FinalProjectFinal\src\finalprojectfinal\Text.txt
        
        FileReader2 read = new FileReader2(filename);
        System.out.println("\nFrames: " +read.frames);
        System.out.println("speed: " +read.speed);
        System.out.println("Number of elemenets: " +read.number_of_elements+"\n");
        //read.Print();

        
        
    }
    
}
