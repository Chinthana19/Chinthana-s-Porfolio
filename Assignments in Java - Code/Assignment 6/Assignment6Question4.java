/*
*   Assignement 6, Question 4: This is a main method that tests the decompose method. It recieves a user input for the radius of the initial circle.
*   Author: Chinthana Sembakutti
*   Date: February 26, 2022
 */
package assignement6;

import java.util.Scanner;

/**
 *
 * @author chint
 */
public class Assignment6Question4 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //getting user input for the radius of the inital circle, setting the value to x
        System.out.print("Enter the radius of the inital circle: ");
        int x = input.nextInt();
        //creating new circle object using radius recieved from user
        Circle cir = new Circle(x);

        //getting result from using decompose method on the initial circle
        Circle[] circList = cir.decompose();

        //printing the radius's of the circles contained in the circle array (circleList) that was returned from
        //the decompose method
        for (int i = 0; i < circList.length; i++) {
            System.out.println("Radius of Circle " + (i + 1) + " is: " + circList[i].getRadius());
        }
    }
}
