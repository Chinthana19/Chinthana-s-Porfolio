/*
*   Assignement 6, Question 5: This program takes an integer input (n) and returns the first n prime numbers. If n = 4,  the first 4 prime numbers will be returned
*   Author: Chinthana Sembakutti
*   Date: February 26, 2022
 */
package assignement6;

import java.util.Scanner;

/**
 *
 * @author chint
 */
public class Assignement6Question5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        //getting user input for the value of n
        System.out.print("Enter the number of prime numbers: ");
        n = input.nextInt();

        //creating new Prime object
        Prime prime = new Prime();

        //using primeNumbers method which will return a int array
        int[] primeList = prime.primeNumbers(n);

        System.out.println("The first " + n + " prime number(s) is:");

        //printing contents of primeList array
        for (int i = 0; i < primeList.length; i++) {
            System.out.println(primeList[i]);
        }
    }
}
