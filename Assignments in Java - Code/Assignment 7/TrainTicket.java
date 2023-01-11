/*
*   Assignment 7, Question 1: This is the TrainTicket class
*   Author: Chinthana Sembakutti
*   Date: March 14, 2022
 */
package assignement7;

import java.util.Date;

/**
 *
 * @author chint
 */
public class TrainTicket extends Ticket {

    //setting vehicleType to "Train" 
    public String vehicleType() {
        return "Train";
    }

    //constructor for TrainTicket
    public TrainTicket(String source, String destination, Date departTime, int price) {
        //constructor for Ticket class
        super(source, destination, departTime, price);
    }

}
