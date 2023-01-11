/*
*   Assignement 4, Question 3: This program uses the Rect class and its methods
*   Author: Chinthana Sembakutti
*   Date: February 6, 2022
 */
package assignment4question3;

import assignement4.*;
import java.util.Scanner;
import java.lang.String;

public class Assignement4Question3 {

    public static void main(String[] args) {
        //creating new scanner object
        Scanner input = new Scanner(System.in);

        //getting user inputs for first rectangle
        System.out.println("Enter the information for the first rectangle:");

        //getting left coordinate input (x)
        System.out.print("Enter the x coordinate of the upper left corner: ");
        int leftCoord1 = input.nextInt();

        //getting upper coordinate input (y)
        System.out.print("Enter the y coordinate of the upper left corner: ");
        int upperCoord1 = input.nextInt();

        //getting right coordinate input (x)
        System.out.print("Enter the x coordinate of the lower right corner: ");
        int rightCoord1 = input.nextInt();

        //getting lower coordinate input (y)
        System.out.print("Enter the y coordinate of the upper left corner: ");
        int lowerCoord1 = input.nextInt();

        //creating rectangle object
        Rect rect1 = new Rect(upperCoord1, leftCoord1, lowerCoord1, rightCoord1);

        //printing rectangle information
        rect1.print();

        //getting user inputs for second rectangle
        System.out.println("Enter the information for the second rectangle:");

        //getting left coordinate input (x)
        System.out.print("Enter the x coordinate of the upper left corner: ");
        int leftCoord2 = input.nextInt();

        //getting upper coordinate input (y)
        System.out.print("Enter the y coordinate of the upper left corner: ");
        int upperCoord2 = input.nextInt();

        //getting right coordinate input (x)
        System.out.print("Enter the x coordinate of the lower right corner: ");
        int rightCoord2 = input.nextInt();

        //getting lower coordinate input (y)
        System.out.print("Enter the y coordinate of the upper left corner: ");
        int lowerCoord2 = input.nextInt();

        //creating second rectangle
        Rect rect2 = new Rect(upperCoord2, leftCoord2, lowerCoord2, rightCoord2);

        //checking is rect1 is larger than rect2 and printing result
        boolean isLarger = rect1.isBiggerThan(rect2);
        System.out.println("The first rectangle is larger than the second: " + isLarger);

        //getting distance to move in x axis
        System.out.print("Enter the distance to move the rectangle in the x direction: ");
        int newX = input.nextInt();

        //getting distance to move in y axis
        System.out.print("Enter the distance to move the rectangle in the y direction: ");
        int newY = input.nextInt();

        //usuing move method to move the rectangle
        rect1.move(newX, newY);

        //printing rectangle information
        rect1.print();

        //getting new length and width from user
        System.out.print("Enter the new length and width of the sides: ");
        int newSize = input.nextInt();

        //changing the size of the rectangle
        rect1.changeSize(newSize);

        //printing information of rectangle
        rect1.print();
    }
}
