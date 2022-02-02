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

    public void createFlights(Flights flights) {
    Flights flightLondon1 = new Flights();
    flightLondon1.setFlights(FlightNumber.BRL456, Locations.LONDON, Locations.BERLIN, 2022-02-12-08-30,120.95,null );

    Flights flightBerlin1 = new Flights();
    flightBerlin1.setFlights(FlightNumber.LDN211, Locations.BERLIN, Locations.LONDON, 2022-02-14-12-45-00, 279.99, null);

    Flights flightLondon2 = new Flights();
    flightLondon2.setFlights(FlightNumber.LDN256, Locations.LONDON, Locations.PARIS, 2022-02-14-06-00-00, 355.65, null);

    Flights flightLondon3 = new Flights();
    flightLondon3.setFlights(FlightNumber.LDN062, Locations.LONDON, Locations.VENICE, 2022-04-05-11-30-00, 79.99, null);

    Flights flightEdinburgh1 = new Flights();
    flightEdinburgh1.setFlights(FlightNumber.EDN456, Locations.EDINBURGH, Locations.MADRID, 2022-05-13-14-20-00, 25.75,null);

        Flights flightMadrid1 = new Flights();
        flightMadrid1.setFlights(FlightNumber.MDR345, Locations.MADRID, Locations.EDINBURGH, 2022-02-29-23-30-00, 110.17, null);
    }

    public void managerMenu(Airline airline){
    boolean loop = true;
        while(loop) {
            int uInput = getFlightService();
            if (uInput == 1) {
                getBookedFlights(airline);
                loop = false;
            } else if (uInput == 2) {
                displayAllFlights(airline);
                loop = false;
            } else if (uInput == 3) {
                displayFlightById(airline);
                loop = false;
            }
            else {
                System.out.println("Sorry input not recognised. Try again...");
            }
        }
}

    public int getFlightService() {
        Scanner flightScanner = new Scanner(System.in);
        System.out.println("Please select an option from the menu below:");
        System.out.println("1 - Display booked flights\n2 - Display all available flights\n3 - Display flight by customer ID");
        int numberInput = flightScanner.nextInt();
        return numberInput;
    }


    public void getBookedFlights(Airline airline){
        // 1. get flights from airline
        Flights[] allArray = airline.getFlights();
        Flights[] bookedFlights = new Flights[allArray.length];
        int num = 0;
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
             bookedFlights) {
            System.out.println(f.getFlightNumber());
        }

    }

    public void displayAllFlights(Airline airline){
        //1. Get airline and get all flights
        System.out.println("Available flights: ");
        // 2. loop through all flights and print flight number
        for (Flights f : airline.getFlights()) {
            System.out.print(f.getFlightNumber() + ", ");
        }

    }
    public void displayFlightById(Airline airline){
        // 1. make scanner to take customer ID
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input customer ID number: ");
        // 2. find customer from ID value
        int id = scanner.nextInt();
        Customer[] customers = airline.getCustomers();
        for (Customer c :
                customers) {
            if (id == c.getId()){
            // 3. find customer's flight and print
            Flights flight = c.getFlight();
            System.out.println("Customer " + id + " flight is: " + flight);
            break;
        } else {
            System.out.println("Customer ID not found.");
        }
    }
}}
