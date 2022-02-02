package com.bnta.flights;

import jdk.javadoc.doclet.Taglet;

import java.time.LocalDateTime;
import java.util.Scanner;

public class FlightService {
    //1. Show a bunch of options from the POJO's below
    //2. Loop.
    //3. Throw error message if user chooses wrong option



public int getFlightService() {
    Scanner flightScanner = new Scanner(System.in); // Initiate and run the scanner.
    System.out.println("");
}

    public Flights[] getBookedFlights(Airline airline){
        // 1. get flights from airline
        Flights[] allArray = new Flights[airline.getFlights().length];
        Flights[] bookedFlights = new Flights[allArray.length];
        int num = 0;
        allArray = airline.getFlights();
        // 2. check if flights[] contains flight, then check each flight fo a customer booking
        if (allArray[0] != null) {
                for (int i = 0; i < allArray.length; i++) {
                    if (allArray[i].getCustomersBooked()[0] != null){
                        // if has booking, add flight to booked array
                        bookedFlights[num] = allArray[i];
                        num++;
                    }
                }
            } else {
            System.out.println("No flights in array");
        }
        return bookedFlights;
    }

    public void displayAllFlights(){
        //1. Call both enums that shows available flight locations and flight number for the corresponding locations
        String flightsAvailable = String.valueOf(Locations.values())+ " " + String.valueOf(FlightNumber.values());
        System.out.println(flightsAvailable);// Check how it looks on the console when your print this string.

    }
    public void displayFlightForID(){
        //We will need to call the customer's iD, scanner for input for the registered ID
     int customerId = 0; // change from zero to call customer Id number from Main/CustomerService

    }
}
