package com.bnta.flights;
import com.bnta.flights.Airline;

import com.bnta.customer.Customer;
import jdk.javadoc.doclet.Taglet;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.Scanner;

public class FlightService {
    //1. Show a bunch of options from the POJO's below
    //2. Loop.
    //3. Throw error message if user chooses wrong option



public int getFlightService() {
    Scanner flightScanner = new Scanner(System.in);
    System.out.println("Please Type for the following Options");
    System.out.println(" 1 - Display Booked Flights" + " 2 - Display All Flights"+ " 3 - Display Flight by ID");
    int numberInput = flightScanner.nextInt();

    return numberInput;
}

    public void Menu(){
        int uInput;

        while(true) {
            uInput = getFlightService();
            if (uInput == 1) {
                getBookedFlights();
            } else if (uInput == 2) {
                displayAllFlights();
            } else if (uInput == 3) {
                displayFlightById();
                break;
            }
            else {
                System.out.println("Sorry input not recognised. Try again...");
            }
        }
}

    public void getBookedFlights(@NotNull Airline airline){
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
        for (Flights f:
             allArray) {
            System.out.println(f.getFlightNumber());
        }

    }

    public void displayAllFlights(){
        //1. Call both enums that shows available flight locations and flight number for the corresponding locations
        String flightsAvailable = new String(String.valueOf(Locations.values())+ " " + String.valueOf(FlightNumber.values()));
        System.out.println(flightsAvailable);// Check how it looks on the console when your print this string.

    }
    public void displayFlightById(Airline airline){
        // 1. make scanner to take customer ID
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input customer ID number: ");
        // 2. find customer from ID value
        int id = scanner.nextInt();
        Customer[] customers = airline.getCustomers();
        // 3. find customer's flight and print


    }
}
