/*
*   Assignement 4, Question 1: This is the Rect class
*   Author: Chinthana
*   Date: February 7, 2022
 */
package assignement4;

public class Rect {

    //properties of the Rect class
    private int left;
    private int top;
    private int length;
    private int width;

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
     * @return the top
     */
    public int getTop() {
        return top;
    }

    /**
     * @param top the top to set
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    //constructor
    public Rect(int length, int width) {
        this.left = 0;
        this.top = 0;
        this.length = negativeCondition(length);
        this.width = negativeCondition(width);
    }

    //constructor including coordinates
    public Rect(int length, int width, int left, int top) {
        this.left = left;
        this.top = top;
        this.length = negativeCondition(length);
        this.width = negativeCondition(width);
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
        this.setLeft(x);
        this.setTop(y);
    }

    //method to change the size of the rectangle
    public void changeSize(int n) {
        this.length = negativeCondition(n);
        this.width = negativeCondition(n);
    }

    //method to check if current rectangle is larger than the input rectangle
    public boolean isBiggerThan(Rect rectInput) {
        if(getArea() > rectInput.getArea()) {
            return true;
        } else{
            return false;
        }
    }
    
    //method to print out the information of the rectangle
    public void print() {
        System.out.println("The x coordinate of the rectangle is: " + this.getLeft());
        System.out.println("The y coordinate of the rectangle is: " + this.getTop());
        System.out.println("The length of the rectangle is: " + this.getLength());
        System.out.println("The width of the rectangle is: " + this.getWidth());
        System.out.println("The circumference of the rectangle is: " + this.getCircumf());
        System.out.println("The area of the rectangle is: " + this.getArea());
    }
}
