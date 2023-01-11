/*
*   Assignment 7, Question 1: This is the ticket class 
*   Author: Chinthana Sembakutti
*   Date: March 11, 2022
 */
package assignement7;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author chint
 */
abstract public class Ticket {

    private static int ticketCount;
    private Person passenger;
    private String source;
    private String destination;
    private String specialMarker;
    private Date departTime;
    private final int price;

    /**
     * @return the ticketCount
     */
    public static int getTicketCount() {
        return ticketCount;
    }

    /**
     * @param aTicketCount the ticketCount to set
     */
    public static void setTicketCount(int aTicketCount) {
        ticketCount = aTicketCount;
    }

    /**
     * @return the passenger
     */
    public Person getPassenger() {
        return passenger;
    }

    /**
     * @param passenger the passenger to set
     */
    public void setPassenger(Person passenger) {
        this.passenger = passenger;
    }

    //So the ticket class can get the vehicle type which isn't 
    //defined in the Ticket class (only BusTicket and TrainTicket classes)
    //polymorphism, since vehicleType can be either "Bus" or "Train" since the
    //ticket could be either a BusTicket or TrainTicket.
    abstract public String vehicleType();

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the specialMarker
     */
    public String getSpecialMarker() {
        return specialMarker;
    }

    /**
     * @param specialMarker the specialMarker to set
     */
    public void setSpecialMarker(String specialMarker) {
        this.specialMarker = specialMarker;
    }

    /**
     * @return the departTime
     */
    public Date getDepartTime() {
        return departTime;
    }

    /**
     * @param departTime the departTime to set
     */
    public void setDepartTime(Date departTime) {
        this.departTime = departTime;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    //constructor for Ticket
    public Ticket(String source, String destination, Date departTime, int price) {
        //incremenets ticketCount so the total number of tickets is tallied
        Ticket.ticketCount++;
        this.source = source;
        this.destination = destination;
        this.departTime = departTime;
        this.price = price;
    }

    //print method
    void print() {
        //using SimpleDateFormat class so date can be printed in specified format
        SimpleDateFormat timeFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        System.out.println("The total number of tickets is: " + getTicketCount());
        System.out.println("Ticket Information:\n\tSource: " + getSource());
        System.out.println("\tDestination: " + getDestination());
        System.out.println("\tDeparture Time: " + timeFormat.format(getDepartTime()));
        System.out.println("\tTicket Price: " + getPrice());

        //So if SpecialMarker hasn't been created yet, it won't print
        if (getSpecialMarker() != null) {
            System.out.println("\tTicket Marker: " + getSpecialMarker());
        }
        //So if passenger hasn't been registered to the ticket, passenger information won't be printed
        if (getPassenger() != null) {
            System.out.println("Passenger Information:\n\tFirst Name: " + getPassenger().getFirstName());
            System.out.println("\tLast Name: " + getPassenger().getLastName());
            System.out.println("\tNational Code: " + getPassenger().getNationalCode());
        }
    }

    //marker method
    private void marker() {
        //creating new Date object that contains current date
        Date date = new Date();
        //using SimpleDateFormat to format date 
        SimpleDateFormat template = new SimpleDateFormat("yyyy.MM.dd");
        //creating specialMarker string. vehicleType is recieved from BusTicket class or TrainTicket class
        setSpecialMarker(getTicketCount() + vehicleType() + template.format(date));
    }

    //resister method
    void register(Person person) {
        //adding person to ticket class
        setPassenger(person);
        //calling marker class to create specialMarker
        marker();
    }
}
