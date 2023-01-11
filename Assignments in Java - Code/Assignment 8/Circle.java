/*
*   Assignement 8, Question 1: This is the Circle class
*   Author: Chinthana Sembakutti
*   Date: March 26, 2022
*/
package assignment8;
import java.lang.Comparable;


/**
 *
 * @author chint
 */
public class Circle implements Comparable<Circle> {
    private int radius;

    //constructor
    public Circle(int radius) {
        this.radius = radius;
    }
    
    @Override //example of polymorphism. compareTo method from the 
              //Comparable Interface is being overriden.
    public int compareTo(Circle circle) {
        //returning result of current circle radius minus input circle radius.
        return (this.radius - circle.radius); 
    }

    //print info method, which prints the radius.
    public void PrintInfo() {
        System.out.println("\t"+this.radius);
    }    
}
