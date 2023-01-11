/*
*   Assignment 5 Question 2: This is the main function for Question 2. It recieves a string length input and outputs a randomized string
*   Author: Chinthana Sembakutti
*   Date: February 12, 2022
 */
package assignement.pkg5;

import java.util.Scanner;

public class Assignment5Question2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //getting user input for length of string
        System.out.print("Enter the integer length of the string: ");
        int n = input.nextInt();
        //creating a RandomString object
        RandomString rand = new RandomString(n);
        //using nextString method
        String str = rand.nextString(n);
        //printing the string that was returned
        System.out.println(str);
    }
}
