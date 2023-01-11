/*
*   Assignement 3, Question 2: This program uses the Rect class and its methods
*   Author: Chinthana Sembakutti
*   Date: January 28, 2022
 */
package assignement.pkg3;

import java.util.Scanner;

public class Assignement3Question2 {

    public static void main(String[] args) {
        //creating new scanner object
        Scanner input = new Scanner(System.in);

        //creating new rectangle object
        //getting user input for length
        System.out.print("Enter the length of the rectangle: ");
        int length = input.nextInt();

        //getting user input for width
        System.out.print("Enter the width of the rectangle: ");
        int width = input.nextInt();

        //getting user input for x coordinate
        System.out.print("Enter the x coordinate the rectangle: ");
        int left = input.nextInt();

        //getting user input for y coordinate
        System.out.print("Enter the y coordinate of the rectangle: ");
        int top = input.nextInt();

        Rect rect = new Rect(left, top, length, width);
        rect.print();

        // ask user to move
        System.out.print("Enter the new x coordinate to move to: ");
        int newLeft = input.nextInt();

        System.out.print("Enter the new y coordinate to move to: ");
        int newTop = input.nextInt();

        rect.move(newLeft, newTop);
        rect.print();

        // ask user to change size
        System.out.print("Enter the new side lenght of the rectangle ");
        int size = input.nextInt();
        rect.changeSize(size);

        //printing the information of the rectangle
        rect.print();
    }

}
