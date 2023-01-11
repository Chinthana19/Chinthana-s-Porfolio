/*
*   Assignment 7, Question 1: This is the BusTicket class
*   Author: Chinthana Sembakutti
*   Date: March 14, 2022
 */
package assignement7;

import java.util.Date;

/**
 *
 * @author chint
 */
public class BusTicket extends Ticket {

    //setting vehicleType to "Bus"
    public String vehicleType() {
        return "Bus";
    }

    //constructor for BusTicket
    public BusTicket(String source, String destination, Date departTime, int price) {
        //constructor for Ticket
        super(source, destination, departTime, price);
    }
}
