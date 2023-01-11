/*
*   Assignement 6, Question 2: This is the main method that uses the addAll method of the circle class
*   Author: Chinthana Sembakutti
*   Date: February 25, 2022
 */
package assignement6;

import java.util.Random;

/**
 *
 * @author chint
 */
public class Assignement6Question2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        Circle[] circleArray = new Circle[100];
        //getting a random number between 10 and 1000
        int x = rand.nextInt(11, 1000);

        //setting the radius values to the circles in circleArray, starting at 1,
        //up to 100
        for (int i = 0; i < 100; i++) {
            circleArray[i] = new Circle(i + 1);
        }

        //creating new circle object using random radius from 10 to 1000
        Circle C = new Circle(x);

        //printing the original radius of circle C
        System.out.println("The radius of the circle C is: " + C.getRadius());

        //using addAll method to add the radius's of all the circled in circleArray
        //to the radius of circle C
        C.addAll(circleArray);

        //printing the new radius of circle C
        System.out.println("The new radius of the circle C is: " + C.getRadius());
    }
}
