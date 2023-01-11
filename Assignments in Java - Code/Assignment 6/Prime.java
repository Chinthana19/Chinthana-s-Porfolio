/*
*   Assignement 6, Question 5: Class for Question 5
*   Author: Chinthana Sembakutti
*   Date: February 26, 2022
 */
package assignement6;

import java.util.ArrayList;

/**
 *
 * @author chint
 */
public class Prime {

    //constructor
    public Prime() {
    }

    //method to find the first n prime numbers
    public int[] primeNumbers(int n) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        int[] primeArray = new int[Math.abs(n)];
        int x = 3;

        //if n is more than 0, 2 is automatically added to the array
        if (n > 0) {
            arrList.add(2);
        } else {
            System.out.println("Error, enter a larger number.");
            System.exit(0);
        }

        //if n is greater than 1, the while loop will run
        while (n > 1) {
            //the variable i is reset to 2 after each iteration
            int i = 2;
            //while i is less than x, the loop will run
            while (i < x) {
                //if x is divisible by i, then it is not prime.
                //The loop will break and x will be incremented and tested again
                if (x % i == 0) {
                    break;
                    //if x isn't divisible by i, i will be incremented and checked if
                    //x is divisible by i again until i >= x
                } else {
                    i++;
                }
                //if i becomes incremented until its >= x, then it means that its
                //prime and will be added to the array
                if (i >= x) {
                    arrList.add(i);
                    break;
                }
            }
            //x is incremented
            x++;
            //if the number of elements in arrList exceeds n, the loop will break
            if (arrList.size() >= n) {
                break;
            }
        }
        //The array list is converted to a int array
        for (int j = 0; j < arrList.size(); j++) {
            primeArray[j] = arrList.get(j);
        }
        //returning the int array primeArray
        return primeArray;
    }
}
