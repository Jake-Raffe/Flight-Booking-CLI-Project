package com.bnta;

import com.bnta.customer.CustomerService;
import com.bnta.flights.Airline;
import com.bnta.flights.ManagerService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // Overview:
        // Main menu
            // 1. Customer menu
            // 2. Manager menu (with password log in)
            // 3. Quit (end process)
        //Customer options
            // 1. book new flight
            // 2. view booked flights
            // 3. cancel flight
            // 4. return to main menu
        // Management options
            // sign in
            // 1. display all available flights
            // 2. display all booked flights
            // 3. display flights for a specific user
            // 4. return to main menu

    //classes:
    // services
        // Main
        // main menu services
        // customer services
        // manager / flight services

    // POJOs
        // Airline
        // flight
        // customer
    // 1. airline
        // flight array
        // customer array
    // 2. customers / user
        // name
        // email
        // id (random UNIQUE number generator)
        // phone number
        // passport number
        // luggage size
        // flight they're booked on
    // 3. flights
        // flight number (enum?)
        // date + time
        // price
        // start location
        // end location
        // customers on flight

    // enums
        // locations
        // flight number
        // luggage (null, small, medium, large)


    public static void main(String[] args) {
        // create initial instances
        Airline airline = new Airline();
        MenuService mainInstance = new MenuService();
        CustomerService customerInstance = new CustomerService();
        ManagerService managerInstance = new ManagerService();
        // create initial available flights and customers
        managerInstance.createFlights(airline);
        customerInstance.setCustomers(airline);
        // run main menu
        mainInstance.mainMenu(airline, customerInstance, managerInstance, mainInstance);
    }
}

// TO DO LIST

    // FIXED:

// MAIN:

// MANAGER FIXES:
// add try catch in customer ID number (manager menu) for inputMismatchException
// managerMenu customerID ask if they want to use another service after No customers booked
// add return to access menu in manager menu and customer menu
// option to view all customers

// CUSTOMER FIXES:
// customer menu repeats on quit
// picking an option from menu repeats menu the first time
// after inputing customer details, flight is not booked
// * 2 - view existing booking: add null pointer exception for no customer (take from manager) / add wrong format try catch
// 1 - create booking:
    // make booking method
    // * add try catch for number inputs (InputMismatchException) passport and number
    // incorrrect flight number trycatch loop
// 3 - cancel booked flight: ends script

// customer display all flights doesn't work



// annotate all with comments


    //CustomerService TO DO:
        // when booking a new flight
            //  run createCustomer and show available flights
            // pick flight, pick baggage. store details to customer array, booked flights array, etc
        // 3. make new method in customer service to find booking by id number
            //
        // 4. make method in Customer Service where they find customer id by putting in other details
        //   ^^change this to cancel existing booking?
        //add quit option

