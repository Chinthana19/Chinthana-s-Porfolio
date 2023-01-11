/*
*   Assignement 6, Question 1: This is the circle class
*   Author: Chinthana Sembakutti
*   Date: February 25, 2022
 */
package assignement6;

import java.util.ArrayList;

/**
 *
 * @author chint
 */
public class Circle {

    private int radius;

    /**
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    //constructor
    public Circle(int radius) {
        this.radius = radius;
    }

    //add method. Works by adding the radius of the input Circle
    //to the radius of current circle.
    public void add(Circle circleInput) {
        this.radius += circleInput.getRadius();
    }

    //addAll method. Works by getting the radius of each circle in the 
    //circleInput array, and adding it to radius of current circle
    public void addAll(Circle[] circleInputs) {
        int count = circleInputs.length;
        for (int i = 0; i < count; i++) {
            this.radius += circleInputs[i].getRadius();
        }
    }

    //decompose method
    public Circle[] decompose() {
        int r = this.radius;

        //creating integer ArrayList to store the prime factors of the radius
        ArrayList<Integer> arr = new ArrayList<Integer>();

        //finding prime factors of current radius. The variable i is set to
        //2 since 1 is not considered as a factor
        for (int i = 2; i < this.radius; i++) {
            //if r is divisible by i, then i is added to an array, and r is then
            //divided by i. If its not divisible, the while loop will be exited
            //and i will be incremented
            while (r % i == 0) {
                arr.add(i);
                r /= i;
            }
        }

        //condition for if the radius is a prime number (no values in integer arraylist)
        if (arr.isEmpty()) {
            arr.add(this.radius);
        }

        //circle array being created using the number of prime factors as the size
        Circle[] circOut = new Circle[arr.size()];

        //creating a integer array, since its a primitive data type
        int[] radiusArray = new int[arr.size()];

        //adding the prime numbers to the radiusArray array, then setting the radius
        //of the circle to its designated value from radiusArray
        for (int j = 0; j < circOut.length; j++) {
            radiusArray[j] = arr.get(j);
            circOut[j] = new Circle(radiusArray[j]);
        }
        //returning the circle array
        return circOut;
    }
}
