/*
*   Assignement 5, Question 3: This is the Book class 
*   Author: Chinthana Sembakutti
*   Date: February 12, 2022
 */
package assignement.pkg5;

/**
 *
 * @author chint
 */
public class Book {

    private String title;
    private String authors;
    private int pageNumber;
    private int yearPublished;
    private int price;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the authors
     */
    public String getAuthors() {
        return authors;
    }

    /**
     * @param authors the authors to set
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     * @return the pageNumber
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * @param pageNumber the pageNumber to set
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * @return the yearPublished
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * @param yearPublished the yearPublished to set
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    //constructor
    public Book(String title, String authors, int pageNumber, int yearPublished, int price) {
        this.title = title;
        this.authors = authors;
        this.pageNumber = pageNumber;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    //second constructor
    public Book(String title, int price, String authors) {
        this.title = title;
        this.price = price;
        this.authors = authors;
        this.pageNumber = 0;
        this.yearPublished = 0;
    }

    //third constructor
    public Book(String title, int pageNumber, int yearPublished, String authors) {
        this.title = title;
        this.pageNumber = pageNumber;
        this.yearPublished = yearPublished;
        this.price = 0;
        this.authors = authors;

    }

    //fourth constructor
    public Book(String title, String authors, int yearPublished) {
        this.title = title;
        this.authors = authors;
        this.yearPublished = yearPublished;
        this.price = 0;
        this.pageNumber = 0;
    }

    //getTitleInTitleCase method
    public String getTitleInTitleCase() {
        //setting another string to the title
        String titleCase = this.title;

        //splitting the string everytime theres a space
        String[] excludeSpace = titleCase.split("\\s+");

        //declaring temporary variables to be used
        String tempFirst, tempWord, tempFinalWord;
        //creating a modifiable string
        StringBuilder tempTitle = new StringBuilder();
        //finding the number of words in title
        int wordCount = excludeSpace.length;

        //takes the first letter of every word, capitalizes it
        //then adds it to the rest of the word.
        //the capitalised words are then added together back into 
        //the title
        for (int j = 0; j < wordCount; j++) {
            tempFirst = excludeSpace[j].substring(0, 1);
            tempWord = excludeSpace[j].substring(1);
            tempFirst = tempFirst.toUpperCase();
            tempFinalWord = tempFirst + tempWord + " ";
            tempTitle.append(tempFinalWord);
        }
        //creating a string from type StringBuilder
        String result = tempTitle.toString();
        //returining the capitalised string
        return result;
    }

    //contains method
    public boolean contains(String str) {
        //changes the title to all lowercase (since .contains is case sensitive)
        String bookTitle = this.title.toLowerCase();
        //changing the input string to lowercase
        str = str.toLowerCase();
        //checking if the title contains the string. Returns true or false
        if (bookTitle.contains(str)) {
            return true;
        } else {
            return false;
        }
    }

    //printAuthors method
    public void printAuthors() {
        //splits the string wherever theres a comma
        String[] authorList = this.authors.split(",");
        //finding number of authors
        int authorCount = authorList.length;
        System.out.println("The Author(s) are: ");
        //printing the authors in different lines
        for (int i = 0; i < authorCount; i++) {
            System.out.println(authorList[i]);
        }
    }
}
