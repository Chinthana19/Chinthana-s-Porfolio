/*
*   Assignement 3, Question 4: This program recieves user inputs and uses the various methods in the Date class
*   Author: Chinthana Sembakutti
*   Date: January 29, 2022
 */
package assignement.pkg3;

import java.util.Scanner;

public class Assignment3Question4 {

    public static void main(String[] args) {
        //creating scanner object to recieve user inputs
        Scanner input = new Scanner(System.in);

        //declaring variables
        int n;
        int day1, month1, year1;
        int day2, month2, year2;

        //taking user input for the year of the first date
        System.out.print("Enter the year of the first date: ");
        year1 = input.nextInt();

        //taking user input for the month of the first date
        System.out.print("Enter the month (1-12): ");
        month1 = input.nextInt();

        //taking user input for the day of the first date
        System.out.print("Enter the day: ");
        day1 = input.nextInt();

        //creaating new Date object using information collected from user
        Date Date1 = new Date(day1, month1, year1);

        //printing out the first date in DD/MM/YYYY to user through print method 
        System.out.print("The first date in DD/MM/YYYY is: ");
        Date1.print();

        //taking user input for the year of the second date
        System.out.print("Enter the year of the second date: ");
        year2 = input.nextInt();

        //taking user input for the month of the second date
        System.out.print("Enter the month (1-12): ");
        month2 = input.nextInt();

        //taking user input for the day of the second date
        System.out.print("Enter the day: ");
        day2 = input.nextInt();

        //creating Date object for the second day using information collected from user
        Date Date2 = new Date(day2, month2, year2);

        //printing the second date using print method
        System.out.print("The second date in DD/MM/YYYY is: ");
        Date2.print();

        //using the compare method to calulate number of days between date1 and date2. Storing in result variable.
        int result = Date1.compare(Date2);

        //printing the result of the compare method
        System.out.println("The number of days between the entered dates is: " + result);

        //taking user input for the number of days to be added to the first date
        System.out.print("Enter the number of days to be added to the first date: ");
        n = input.nextInt();
        //using addDays method to add the n to Date1
        Date1.addDays(n);

        //using print method to print the result
        System.out.printf("The result of adding %d to the first date is: ", n);
        Date1.print();
    }

}
