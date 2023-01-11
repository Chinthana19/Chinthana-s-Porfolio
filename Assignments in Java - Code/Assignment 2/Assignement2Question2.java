/*
*   Assignment 1, Question 2: This program outputs all prime numbers up to 10,000
*   Author: Chinthana Sembakutti
*   Date: January 22, 2021
 */
package assignement.pkg2;

public class Assignement2Question2 {

    public static void main(String[] args) {
        int n = 10000;

        for (int j = n; j > 0; j--) {
            switch (j) {
                case 2: //in case the number is 2, which is prime
                    System.out.println(j);
                    break;
                default: //if the number isn't 2, it will be further tested to see if its a prime number
                    for (int i = 2; i < j; i++) { 

                        if (j % i == 0) { //checking if the number is divisble by i. If it is the loop will break
                            break;
                        }
                        if (i > (j / 2)) { //if the a divisor cannot be found, and i is greater than half of a number, the number is prime
                            System.out.println(j); //printing the prime number
                            break;
                        }
                    }
                    break;
            }
        }
    }

}
