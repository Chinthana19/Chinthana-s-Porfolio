/*
*   Assignement 8, Question 1: This is the student class
*   Author: Chinthana Sembakutti
*   Date: March 26, 2022
 */
package assignment8;

import java.lang.Comparable;

/**
 *
 * @author chint
 */
public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private int studentNumber;
    private double gpa;


    //constructor
    public Student(String firstName, String lastName, int studentNumber, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.gpa = gpa;
    }
    
    @Override           //example of polymorphism, as the compareTo method from the 
                        //Comparable interface is being overriden.
    public int compareTo(Student student) {
        //if first and last name and student number, and gpa is equal,
        //0 will be returned.
        if (this.firstName.equalsIgnoreCase(student.firstName)
                && this.lastName.equalsIgnoreCase(student.lastName)
                && this.studentNumber == student.studentNumber
                && this.gpa == student.gpa) {
            return 0;
        }
        //if current student gpa is greater than input student, then a positive number
        //will be returned (+1)
        if(this.gpa > student.gpa) {
            return 1;
        } else {
            //if current student gpa is smaller than input student, then a negative number
            //will be returned (-1)
            return -1;
        }
    }
    
    //printinfo method, to print student first and last name, student number, and gpa.
    public void PrintInfo() {
        System.out.println("\tStudent Name: " +this.firstName+" "+this.lastName);
        System.out.println("\tStudent Number: "+this.studentNumber);
        System.out.println("\tStudent GPA: "+this.gpa+"\n");
    }
}
