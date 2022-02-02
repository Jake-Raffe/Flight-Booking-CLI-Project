package com.bnta.flights;

import jdk.javadoc.doclet.Taglet;

import java.time.LocalDateTime;
import java.util.Scanner;

public class FlightService {
    //1. Show a bunch of options

    //display available flights
    // display booked flights
    // max capacity ?
    // Throw exception if flight is full
    //Throw exception if the flight isn't valid


    public Flights[] displayBookedFlights(Airline airline){
        // 1. get flights from airline
        // 2. loop through each flight
        // 3. for each flight, loop through booked customers
        // 4. if flight has booked customers, add flight to "bookedArray", if not -> skip
        // 5. return array of booked flights: "bookedArray (flights with customers)



    }

    public void displayAllFlights(){
        //1. Call both enums that shows available flight locations and flight number for the corres
        String flightsAvailable = String.valueOf(Locations.values())+ String.valueOf(FlightNumber);
        System.out.println(flightsAvailable);

    }
    public void displayFlightForID(){
        //We will need to call the customer's iD, scanner for input for the registered ID
     int customerId = 0; // change from zero to call customer Id number from Main/CustomerService

    }
}
