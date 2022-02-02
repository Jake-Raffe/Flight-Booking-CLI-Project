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

    public void createFlights(Airline airline) {
    Flights[] flightArr = new Flights[7];
        Flights flightLondon1 = new Flights();
    flightLondon1.setFlights(FlightNumber.BRL456, Locations.LONDON, Locations.BERLIN, "12 February 2022 08:30:00",120.95,null );
        flightArr[0] = flightLondon1;
    Flights flightBerlin1 = new Flights();
    flightBerlin1.setFlights(FlightNumber.LDN211, Locations.BERLIN, Locations.LONDON, "14 February 2022 12:45:00", 279.99, null);
        flightArr[1] = flightBerlin1;
    Flights flightLondon2 = new Flights();
    flightLondon2.setFlights(FlightNumber.LDN256, Locations.LONDON, Locations.PARIS,"14 February 2022 06:00:00", 355.65, null);
        flightArr[2] = flightLondon2;
    Flights flightLondon3 = new Flights();
    flightLondon3.setFlights(FlightNumber.LDN062, Locations.LONDON, Locations.VENICE,"12 March 2022 16:20:00", 79.99, null);
        flightArr[3] = flightLondon3;
    Flights flightEdinburgh1 = new Flights();
    flightEdinburgh1.setFlights(FlightNumber.EDN456, Locations.EDINBURGH, Locations.MADRID, "13 May 2022 13:13:00", 25.75,null);
        flightArr[4] = flightEdinburgh1;
    Flights flightMadrid1 = new Flights();
    flightMadrid1.setFlights(FlightNumber.MDR345, Locations.MADRID, Locations.EDINBURGH, "28 June 2022 21:50:00", 110.17, null);
        flightArr[5] = flightMadrid1;
    Flights flightVenice1 = new Flights();
    flightVenice1.setFlights(FlightNumber.VCE675, Locations.VENICE, Locations.MADRID, "26 July 2022 16:35:00", 207.35, null);
        flightArr[6] = flightVenice1;
        airline.setFlights(flightArr);
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
