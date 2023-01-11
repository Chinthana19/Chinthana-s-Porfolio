/*
*   Assignment 1, Question 1: This program outputs all prime numbers up to 10,000
*   Author: Chinthana Sembakutti
*   Date: January 22, 2021
 */
package assignement.pkg2;

public class Assignement2Question1 {

    public static void main(String[] args) {
        int n = 10000;
        while (n > 0) {
            int i = 2; //starting i at 2, since all numbers are divisible by 1.
            while (i < n) {
                if (n % i == 0) { // checking if n is divisible by a number i. If it is the loop will break
                    break;
                } else {
                    i++; //increase i to test is n is divisble by the new i value
                }
                if (i > (n / 2)) { //if i is greater than half of n, the number will be prime.(no number greater than half of n is a divisor)
                    System.out.println(n); //prints n, since it would be a prime number 
                    break;
                }
            }
            n--; //decrementing n so the next number can be tested to see if its a prime number
            if (n == 2) { //in case n is 2, which is a prime number.
                System.out.println(n);
            }
        }

    }
}
