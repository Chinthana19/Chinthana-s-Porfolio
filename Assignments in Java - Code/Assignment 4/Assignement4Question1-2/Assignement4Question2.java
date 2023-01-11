/*
*   Assignement 4, Question 2: This program uses the Rect class and its methods
*   Author: Chinthana Sembakutti
*   Date: February 6, 2022
 */
package assignement4;

import java.util.Scanner;
import java.lang.String;

public class Assignement4Question2 {

    public static void main(String[] args) {
        //creating new scanner object
        Scanner input = new Scanner(System.in);

        //getting user input for length
        System.out.println("Enter the information of the first rectangle:");
        System.out.print("Enter the length of the first rectangle: ");
        int length = input.nextInt();

        //getting user input for width
        System.out.print("Enter the width of the first rectangle: ");
        int width = input.nextInt();

        //getting user input for length for second rectangle
        System.out.println("Enter the information of the second rectangle");
        System.out.print("Enter the length of the second rectangle: ");
        int length2 = input.nextInt();

        //getting user input for width for second rectangle
        System.out.print("Enter the width of the second rectangle: ");
        int width2 = input.nextInt();

        //asking user if they want to enter coordinates, and getting the input
        System.out.print("Do you wish to enter coordinates for the rectangles? Enter Y/N: ");
        char userChoice = input.next().charAt(0);

        //decides if user wants to enter coordinates
        if (userChoice == 'Y' || userChoice == 'y') {
            //getting user input for x coordinate
            System.out.print("Enter the x coordinate the first rectangle: ");
            int left = input.nextInt();

            //getting user input for y coordinate
            System.out.print("Enter the y coordinate of the first rectangle: ");
            int top = input.nextInt();

            //getting user input for x coordinate (rectangle 2)
            System.out.print("Enter the x coordinate the second rectangle: ");
            int left2 = input.nextInt();

            //getting user input for y coordinate (rectangle 2)
            System.out.print("Enter the y coordinate of the second rectangle: ");
            int top2 = input.nextInt();

            //creating rectangle objects
            Rect rect = new Rect(length, width, left, top);
            Rect rect2 = new Rect(length2, width2, left2, top2);

            //printing information of rectangle
            rect.print();

            //checking if rect is larger than rect2, and printing the result
            boolean sizeCheck = rect.isBiggerThan(rect2);
            System.out.println("The first rectangle is larger than the second: " + sizeCheck);

            //getting user input for the new x coordinate
            System.out.print("Enter the new X coordinate for the first rectangle: ");
            int newX = input.nextInt();

            //getting user input for the new y coordinate
            System.out.print("Enter the new Y coordinate for the first rectangle: ");
            int newY = input.nextInt();

            //using move method to change x,y coordinates
            rect.move(newX, newY);

            //getting user input for new length and width 
            System.out.print("Enter the new length and width of the first rectangle: ");
            int newSize = input.nextInt();

            //using changeSize method to change size of rectangle
            rect.changeSize(newSize);

            //printing rectangle information
            rect.print();

            //if user doesn't want coordinate information 
        } else if (userChoice == 'N' || userChoice == 'n') {
            //creating rectangle objects
            Rect rect = new Rect(length, width);
            Rect rect2 = new Rect(length2, width2);

            //printing rectangle information
            rect.print();

            //checking if rect is larger than rect2, and printing the result
            boolean sizeCheck = rect.isBiggerThan(rect2);
            System.out.println("The first rectangle is larger than the second: " + sizeCheck);

            //getting user input for the new x coordinate            
            System.out.print("Enter the new X coordinate for the first rectangle: ");
            int newX = input.nextInt();

            //getting user input for the new y coordinate            
            System.out.print("Enter the new Y coordinate for the first rectangle: ");
            int newY = input.nextInt();

            //using move method to change x,y coordinates
            rect.move(newX, newY);

            //getting user input for new length and width 
            System.out.print("Enter the new length and width of the first rectangle: ");
            int newSize = input.nextInt();

            //using changeSize method to change size of rectangle
            rect.changeSize(newSize);

            //printing rectangle information
            rect.print();

            //if user enters invalid input
        } else {
            System.out.println("Error, Invalid Input.");
            System.exit(0);
        }
    }

}
