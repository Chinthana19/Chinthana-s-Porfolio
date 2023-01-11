/*
*   Assignement 3, Question 3: This is the Date class
*   Author: Chinthana
*   Date: January 28, 2022
 */
package assignement.pkg3;

public class Date {

    //properties of the Date class
    private int year;
    private int month;
    private int day;

    //constructor
    public Date(int day, int month, int year) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //prints date in the form DD/MM/YYYY
    public void print() {
        System.out.printf("%02d/%02d/%04d\n", day, month, year);
    }

    //addDays method to add number of days (n) to the date.
    public void addDays(int n) {
        boolean runCondition = true;

        //adding n to number of days
        this.day += n;

        //considering case of february, which only has 28 days, if the number of days is more than 28.
        if ((month == 2) && (day > 28)) {
            this.month += 1;
            this.day -= 28;
            if (day <= 28) {
                //stops while loop from running
                runCondition = false;
            }
        }

        //while loop since the number of days could be larger than 30, and multiple months/years may have to be changed
        while (runCondition) {
            boolean monthCheck = false;

            //considering months with 31 days
            if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
                monthCheck = true;
            }

            //in the case theres more than 31 days, and the month contains 31 days
            if ((day > 31) && (monthCheck == true)) {
                this.month += 1;
                this.day -= 31;
                if (month > 12) {
                    this.year += 1;
                    this.month = 1;
                }
                //in the case there more than 30 days, and the month contains 30 days
            } else if ((day > 30) && monthCheck == false) {
                this.month += 1;
                this.day -= 30;
                if (month > 12) {
                    this.year += 1;
                    this.month = 1;
                }
            }
            //if the date becomes valid (days is less than 31) the loop will break
            if (day <= 31) {
                runCondition = false;
            }
        }
    }

    //compare dates methid, to calculate number of days between the 2 dates. 
    //works by turning years and months into days, and subtracts them
    public int compare(Date dateInput) {
        //declaring variables 
        int inputYear = dateInput.year;
        int inputMonth = dateInput.month;
        int inputDay = dateInput.day;
        int currentDay = this.day;
        int currentMonth = this.month;
        int currentYear = this.year;
        int sumInput = 0;
        int sumCurrent = 0;
        int result;
        boolean runCondition = true;

        //adding the number of days to the respective sum variables
        sumInput += inputDay;
        sumCurrent += currentDay;

        //loop to turn the months into their number of days. For example, if the month is May, then the number of days in April (30), March (31), February (28), and January (31) will be added.
        while (runCondition) {
            //decreases the month, as the number of days in the current month have already been accounted for
            currentMonth--;
            //checks what the month is, then adds the respective number of days to the sum variable
            if ((currentMonth == 1) || (currentMonth == 3) || (currentMonth == 5) || (currentMonth == 7) || (currentMonth == 8) || (currentMonth == 10) || (currentMonth == 12)) {
                sumCurrent += 31;
            } else if ((currentMonth == 4) || (currentMonth == 6) || (currentMonth == 9) || (currentMonth == 11)) {
                sumCurrent += 30;
            } else if (currentMonth == 2) {
                sumCurrent += 28;
            }
            //after all months have been accounted for, the loop will break
            if (currentMonth == 0) {
                runCondition = false;
            }
        }
        runCondition = true;

        //Works similar to the previous loop, except this deals with the second date
        while (runCondition) {
            inputMonth--;
            if ((inputMonth == 1) || (inputMonth == 3) || (inputMonth == 5) || (inputMonth == 7) || (inputMonth == 8) || (inputMonth == 10) || (inputMonth == 12)) {
                sumInput += 31;
            } else if ((inputMonth == 4) || (inputMonth == 6) || (inputMonth == 9) || (inputMonth == 11)) {
                sumInput += 30;
            } else if (inputMonth == 2) {
                sumInput += 28;
            }
            if (inputMonth == 0) {
                runCondition = false;
            }
        }

        //turning the years of the 2 dates into the number of days (leap years are ignored)
        sumCurrent += currentYear * 365;
        sumInput += inputYear * 365;

        //calculating the number of days between each date.
        if (sumInput > sumCurrent) {
            result = sumInput - sumCurrent;
        } else {
            result = sumCurrent - sumInput;
        }
        return result;
    }

}
