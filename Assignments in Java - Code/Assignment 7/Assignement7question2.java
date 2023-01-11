/*
*   Assignment 7, Question 2: This is the main method of the ticket class
*   Author: Chinthana Sembakutti
*   Date: March 11, 2022
 */
package assignement7;

import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author chint
 */
public class Assignement7question2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //creating new Assignement7question2 instance so its methods can be used
        Assignement7question2 assignment = new Assignement7question2();

        //getting user inpit for number of tickets
        System.out.print("Enter number of tickets: ");
        int numberOfTickets = input.nextInt();

        //running for loop to create specified amount of tickets, and fill in its information
        for (int i = 0; i < numberOfTickets; i++) {
            //calling CreateAndPrintTicket method
            assignment.CreateAndPrintTicket();
        }
    }

    public void CreateAndPrintTicket() {
        Scanner input = new Scanner(System.in);

        //getting vehicle type from user
        System.out.print("Enter the Vehicle type (Bus or Train): ");
        String vehicleType = input.nextLine();
        //creating ticket (will be a BusTicket or TrainTicket) by calling getTicketForVehicle method and passing vehicleType
        Ticket ticket = getTicketForVehicle(vehicleType);
        //if user entered something other than "Bus" or "Train", program will exit
        if (ticket == null) {
            System.exit(0);
        }
        //calling print method of Ticket class to print ticket information (inheritance)
        ticket.print();
    }

    public Ticket getTicketForVehicle(String vehicle) {
        //if user entered something other than "Bus" or "Train" program will print error, then exit.
        if (!vehicle.equalsIgnoreCase("Bus") && !vehicle.equalsIgnoreCase("Train")) {
            System.out.println("Error, vehicle type is not valid.");
            return null;
        }
        Scanner input = new Scanner(System.in);

        //recieving user inputs for person first name, last name, national code
        System.out.print("Enter First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Enter National Code: ");
        String nationalCode = input.nextLine();

        //creating person object using information recieved from user
        Person person = new Person(firstName, lastName, nationalCode);

        //getting user input for ticket information
        System.out.print("Enter Starting Location: ");
        String source = input.nextLine();

        System.out.print("Enter the Destination: ");
        String destination = input.nextLine();

        System.out.print("Enter the Departure time in MM/DD/YYYY HH:mm format: ");
        Date departTime = new Date(input.nextLine());

        System.out.print("Enter the Ticket Price: ");
        int price = input.nextInt();

        //creating the required ticket. If user entered "Bus" as vehicle, then a BusTicket will be created,
        //and then a Ticket will be created inside of the BusTicket class. If user entered "Train" then a TrainTicket
        //will be created, and a Ticket will be created inside of the TrainTicket class. 
        //register method has been inherited from Ticket class
        if (vehicle.equalsIgnoreCase("bus")) {
            Ticket ticket = new BusTicket(source, destination, departTime, price);
            ticket.register(person);
            return ticket;
        } else {
            Ticket ticket = new TrainTicket(source, destination, departTime, price);
            ticket.register(person);
            return ticket;
        }
    }
}
