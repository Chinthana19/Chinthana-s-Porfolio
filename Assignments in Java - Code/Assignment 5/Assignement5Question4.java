/*
*   Assignement 5, Question 4: This program recieves user inputs and uses the methods in the Book class
*   Author: Chinthana Sembakutti
*   Date: February 13, 2022
 */
package assignement.pkg5;

import java.util.Scanner;

/**
 *
 * @author chint
 */
public class Assignement5Question4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //getting user input for book title
        System.out.print("Enter the book title: ");
        String title = input.nextLine();

        //getting user input for book authors
        System.out.print("Enter the books author(s), seperated by commas if multiple: ");
        String authors = input.nextLine();

        //getting user input for number of pages
        System.out.print("Enter the number of pages of the book: ");
        int pageNumber = input.nextInt();

        //getting user input for year of publishing
        System.out.print("Enter the year the book was published: ");
        int year = input.nextInt();

        //getting user input for price of book
        System.out.print("Enter the price of the book: ");
        int price = input.nextInt();

        //creating book object using data collected from user
        Book book = new Book(title, authors, pageNumber, year, price);

        //using getTitleInTitleCase method 
        String titleCase = book.getTitleInTitleCase();

        //printing the title with first letter of every word capitalized
        System.out.println("The title with proper capitilization is: " + titleCase);
        //skipping a line from being scanned (to avoid a error where the user isn't prompted for input)
        input.skip("\\R?");

        //getting user input of string to see if its contained in the title
        System.out.print("Enter string to check if its contained in the title: ");
        String str = input.nextLine();

        //using contains method, and printing result
        boolean stringContains = book.contains(str);
        System.out.printf("The title contains '%s': %s\n", str, stringContains);

        //using printAuthors method to print authors
        book.printAuthors();
    }
}
