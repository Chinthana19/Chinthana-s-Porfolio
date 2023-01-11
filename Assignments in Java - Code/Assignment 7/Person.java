/*
*   Assignment 7, Question 1: This is the person class 
*   Author: Chinthana Sembakutti
*   Date: March 11, 2022
 */
package assignement7;

/**
 *
 * @author chint
 */
public class Person {

    private String firstName;
    private String lastName;
    private String nationalCode;

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the nationalCode
     */
    public String getNationalCode() {
        return nationalCode;
    }

    /**
     * @param nationalCode the nationalCode to set
     */
    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    //constructor for Person class
    public Person(String firstName, String lastName, String nationalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
    }

}
