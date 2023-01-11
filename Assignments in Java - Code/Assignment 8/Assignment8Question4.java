/*
*   Assignement 8, Question 4: This program tests the methods of the Utility 
*   Author: Chinthana Sembakutti
*   Date: March 26, 2022
 */
package assignment8;

import java.lang.Comparable;

/**
 *
 * @author chint
 */
public class Assignment8Question4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Utility util = new Utility();

        //creating and giving values to array of 10 student objects
        Student[] studentArray = new Student[10];
        studentArray[0] = new Student("Harry", "Potter", 82933, 89.2);
        studentArray[1] = new Student("Ron", "Weasley", 68238, 76.5);
        studentArray[2] = new Student("Hermione", "Granger", 83829, 99);
        studentArray[3] = new Student("James", "May", 21242, 87);
        studentArray[4] = new Student("Jeremy", "Clarkson", 45232, 5);
        studentArray[5] = new Student("Richard", "Hammond", 12423, 66);
        studentArray[6] = new Student("Percy", "Jackson", 82748, 12);
        studentArray[7] = new Student("Hermione", "Granger", 83829, 99);
        studentArray[8] = new Student("James", "May", 21242, 87);
        studentArray[9] = new Student("Jeremy", "Clarkson", 45232, 5);

        //calling the max and min method from the Utility class and storing
        //the result as a Student object.
        Student maxStudent = (Student) (util.max(studentArray)); //casting to Type Student
        Student minStudent = (Student) (util.min(studentArray)); //casting to Type Student

        //Using the PrintInfo method 
        System.out.println("Student with greatest GPA: ");
        maxStudent.PrintInfo();

        System.out.println("Student with smallest GPA:");
        minStudent.PrintInfo();

        //Using the removeRepetition method from the Utility class to remove
        //duplicates. Returns an Array of type Comparable.
        System.out.println("List of Students without Duplicates:");
        Comparable[] outStudent = util.removeRepetition(studentArray);
        for (int i = 0; i < outStudent.length; i++) {
            Student tmpStudent = (Student) (outStudent[i]); //casting to Type Student
            tmpStudent.PrintInfo(); //Printing info
        }

        //Creating and giving values to array of 10 Circle objects
        Circle[] circles = new Circle[10];
        circles[0] = new Circle(10);
        circles[1] = new Circle(20);
        circles[2] = new Circle(20);
        circles[3] = new Circle(40);
        circles[4] = new Circle(40);
        circles[5] = new Circle(10);
        circles[6] = new Circle(20);
        circles[7] = new Circle(90);
        circles[8] = new Circle(70);
        circles[9] = new Circle(30);

        //Calling the max and min method and storing results as Circle Objects
        Circle maxCircle = (Circle) (util.max(circles)); //casting Type Circle to result
        Circle minCircle = (Circle) (util.min(circles)); //castign Type Circle to result

        //Printing the smallest and greatest radius
        System.out.print("Minimum Circle Radius: ");
        minCircle.PrintInfo();

        System.out.print("Maximum Circle Radius: ");
        maxCircle.PrintInfo();

        //Calling the removeRepetition method and storing the result as an array
        //of type Comparable. 
        System.out.println("List of Circle Radius's without Duplicates:");
        Comparable[] outCircle = util.removeRepetition(circles);
        for (int i = 0; i < outCircle.length; i++) {
            Circle tmpCirc = (Circle) (outCircle[i]); //casting Type Circle to result
            tmpCirc.PrintInfo(); //printing radius of circle.
        }
    }
}
