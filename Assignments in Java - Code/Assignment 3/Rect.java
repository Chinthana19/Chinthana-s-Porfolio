/*
*   Assignement 3, Question 1: This is the Rect class
*   Author: Chinthana
*   Date: January 28, 2022
 */
package assignement.pkg3;

public class Rect {

    //properties of the Rect class
    private int left;
    private int top;
    private int length;
    private int width;

    //constructor
    public Rect(int left, int top, int length, int width) {
        this.left = left;
        this.top = top;
        this.length = length;
        this.width = width;
    }
    //method to calculate circumference of rectangle
    public double getCircumf() {
        return 2 * (length + width);
    }

    //method to calculate area of rectangle
    public double getArea() {
        return length * width;
    }

    //method to change the coordinates of the rectangle
    public void move(int x, int y) {
        this.left = x;
        this.top = y;
    }

    //method to change the size of the rectangle
    public void changeSize(int n) {
        this.length = n;
        this.width = n;
    }

    //method to print out the information of the rectangle
    public void print() {
        System.out.println("The x coordinate of the rectangle is: " + this.left);
        System.out.println("The y coordinate of the rectangle is: " + this.top);
        System.out.println("The length of the rectangle is: " + this.length);
        System.out.println("The width of the rectangle is: " + this.width);
        System.out.println("The circumference of the rectangle is: " + this.getCircumf());
        System.out.println("The area of the rectangle is: " + this.getArea());
    }
}
