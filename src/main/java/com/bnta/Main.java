package com.bnta;

import com.bnta.customer.CustomerService;
import com.bnta.manager.Airline;
import com.bnta.manager.ManagerService;

public class Main {

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



// MANAGER FIXES:
// in manager menu, input error repeats once and then takes you back to menu
// 1 - flight number of booked flights
    // no flights repeats when try to use another service
// add try catch in customer ID number (manager menu) for inputMismatchException
// managerMenu customerID ask if they want to use another service after No customers booked
// after service > use another service: no > quit out
// option to view all customers
// change view flight numbers to all flight details

// CUSTOMER FIXES:
// customer menu repeats on quit
// picking an option from menu repeats menu the first time
// after inputing customer details, flight is not booked
// 2 - view existing booking:
    // add null pointer exception for no customer (take from manager) / add wrong format try catch
// 1 - create booking:
    // make booking method
    // * add try catch for number inputs (InputMismatchException) passport and number
    // incorrrect flight number trycatch loop
// 3 - cancel booked flight: ends script
    // need to create the method

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

