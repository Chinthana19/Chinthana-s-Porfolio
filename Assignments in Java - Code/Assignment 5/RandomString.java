/*
*   Assignement 5 Question 2: This is the RandomString class
*   Author: Chinthana Sembakutti
*   Date: February 12, 2022
*/
package assignement.pkg5;

import java.util.Random;

/**
 *
 * @author chint
 */
public class RandomString {
    private int n;

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
    }

    //constructor
    public RandomString(int n) {
        this.n = n;
    }

    //nextString method
    public String nextString(int n) {
        int x = this.getRandom();
        String randStr;
        while (true) {
            //ensuring that the first letter of the string isn't a number
            //if its number, a new random x value is selected until its valid
            if (x < 58) {
                x = this.getRandom();
            } else {
                break;
            }
        }
        //adding first letter to string
        randStr = Character.toString((char)x);

        //getting the other random letters/digits and adding it to the string
        for (int i = 1; i < n; i++) {
            x = this.getRandom();
            randStr += Character.toString((char)x);
        }
        //returning the string
        return randStr;
    }

    //get random method (returns a random number that meets conditions)
    public int getRandom() {
        Random rand = new Random();
        int x;
        while (true) {
            //range for random number
            x = rand.nextInt(48, 122);
            //in case an invalid number is selected
            if ((x > 57 && x < 65) || x > 90 && x < 97) {
                continue;
            } else {
                break;
            }
        }
        return x;
    }
}
