/*
*   Assignment 5, Question 1: This program takes a string input and outputs its characters with number of occurences.
*   Author: Chinthana Sembakutti
*   Date: Februrary 12, 2022
*/
package assignement.pkg5;

import java.util.Scanner;

public class Assignement5Question1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        //recieving string input
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        //initializing variables
        int counter = 1;
        char ch = '\0';

        //works by finding the first character, then comparing the 
        //first character to the second, third, fourth, etc until the 
        //comparison is false (second character is not the same as the first).
        //It will then print the original character, and then the number of occurences
        //of that character in a row (except for when its only 1) and then repeat the process
        //with the next character in the string.
        int length = str.length();
        for (int i = 0; i < length;) {
            counter = 1;
            ch = str.charAt(i);
            while (true) {
                i++;
                if (i >= length) {
                    break;
                }
                char ch2 = str.charAt(i);
                if (ch == ch2) {
                    counter++;
                } else {
                    if (counter == 1) {
                        System.out.printf("%c", ch);
                    } else {
                        System.out.printf("%c%d", ch, counter);
                    }
                    break;
                }
            }
        }
        //prints the last letter or group of letters
        if (counter == 1) {
            System.out.printf("%c\n", ch);
        } else {
            System.out.printf("%c%d\n", ch, counter);
        }
    }
}
