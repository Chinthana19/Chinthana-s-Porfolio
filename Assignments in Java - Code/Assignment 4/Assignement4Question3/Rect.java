/*
*   Assignement 4, Question 3: This is the Rect class
*   Author: Chinthana
*   Date: February 7, 2022
 */
package assignment4question3;

public class Rect {

    //properties of the Rect class
    private int upper;
    private int left;
    private int lower;
    private int right;

    /**
     * @return the upper
     */
    public int getUpper() {
        return upper;
    }

    /**
     * @param upper the upper to set
     */
    public void setUpper(int upper) {
        this.upper = upper;
    }

    /**
     * @return the left
     */
    public int getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(int left) {
        this.left = left;
    }

    /**
     * @return the lower
     */
    public int getLower() {
        return lower;
    }

    /**
     * @param lower the lower to set
     */
    public void setLower(int lower) {
        this.lower = lower;
    }

    /**
     * @return the right
     */
    public int getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(int right) {
        this.right = right;
    }

    //constructor 
    public Rect(int upper, int left, int lower, int right) {
        this.upper = upper;
        this.left = left;
        this.lower = lower;
        this.right = right;
    }

    //method to get width from coordinates
    public int getWidth() {
        return negativeCondition(this.upper - this.lower);
    }

    //method to get length from coordinates
    public int getLength() {
        
        return negativeCondition(this.left - this.right);
    }

    //method to ensure lenght and width are positive and not equal to 0
    private int negativeCondition(int size) {
        if (size < 0) {
            size *= -1;
        } else if (size == 0) {
            size = 1;
        }
        return size;
    }

    //method to calculate circumference of rectangle
    public double getCircumf() {
        return 2 * (getLength() + getWidth());
    }

    //method to calculate area of rectangle
    public double getArea() {
        return getLength() * getWidth();
    }

    //method to change the coordinates of the rectangle
    public void move(int x, int y) {
        this.upper += y;
        this.lower += y;
        this.left += x;
        this.right += x;
    }

    //method to change the size of the rectangle
    public void changeSize(int n) {
        this.lower = this.upper + n;
        this.right = this.left + n;
    }

    //checks if the current rectangle object has a greater area than an inputted rectangle object
    public boolean isBiggerThan(Rect rectInput) {
        return this.getArea() > rectInput.getArea();
    }

    //method to print out the information of the rectangle
    public void print() {
        System.out.printf("The (x,y) coordinates of the upper left corner is: (%d, %d)\n", this.left, this.upper);
        System.out.printf("The (x,y) coordinates of the lower right corner is: (%d, %d)\n", this.right, this.lower);
        System.out.println("The length of the rectangle is: " + this.getLength());
        System.out.println("The width of the rectangle is: " + this.getWidth());
        System.out.println("The circumference of the rectangle is: " + this.getCircumf());
        System.out.println("The area of the rectangle is: " + this.getArea());
    }
}
