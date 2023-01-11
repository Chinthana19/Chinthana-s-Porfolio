/*
*   Assignement 5, Question 5: This program recieves user input for email addresses, and calculates the number
                                of '@gmail.com' addresses, and addresses containing '_'
*   Author: Chinthana Sembakutti
*   Date: February 13, 2022
 */
package assignement.pkg5;

import java.util.Scanner;

/**
 *
 * @author chint
 */
public class Assignement5Question5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //getting user input for email addresses
        System.out.print("Enter email addresses, seperating each with a comma ',' space ' ' or semicolon ';': ");
        String str = input.nextLine();

        //replacing every condition of multiple spaces in a row with just 1
        String emails = str.replaceAll("\\s+", " ");

        //splitting string according to conditions (comma, semicolon, space)
        String[] emailList = emails.split("[,; ]");

        //finding number of email addresses, and initialising counter variables
        int emailCount = emailList.length;
        int counterUnderscore = 0;
        int counterGmail = 0;

        //checks if each substring contains a underscore ('_') or @gmail.com
        //if true, counter variable is incremented
        for (int i = 0; i < emailCount; i++) {
            if (emailList[i].contains("_")) {
                counterUnderscore++;
            }
            if (emailList[i].contains("@gmail.com")) {
                counterGmail++;
            }
        }
        //printing results
        System.out.printf("There are %d email addresses containing an underscore '_'.\n", counterUnderscore);
        System.out.printf("There are %d email addresses associated with Gmail.\n", counterGmail);
    }
}
