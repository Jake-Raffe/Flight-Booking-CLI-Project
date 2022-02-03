package com.bnta;

import com.bnta.customer.Customer;
import com.bnta.customer.CustomerService;
import com.bnta.customer.Luggage;
import com.bnta.flights.Airline;
import com.bnta.flights.FlightService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // plan:
    //Customer options
        // 1. book new flight
        // 2. view booked flights
        // 3. cancel flight
        // 4. sign out / end
    // Management options
        // sign in
        // 1. display all available flights
        // 2. display all booked flights
        // 3. display flights for a specific user
        // 4. sign out / end

    //classes
    // POJOs
        //  Airline
        //flight
        //airline
    // 1. customers/ user
    // name
    // email
    // id (random generator)
    // phone number
    // passport number
    // luggage?
    // 2. flights
    // flight number (enum?)
    // date + time
    // price
    // start location
    // end location
    // customers on flight
    // airline
    // methods
    // 1. writes to file
    // 2. edits (amend/remove from) file
    // Service
    //

    // enums
    // airline
    // flight number(?)
    // luggage (null, small, large / num of bags)




    public static void main(String[] args) {
        // create initial available flights, and instances
        Airline airline = new Airline();
        Main mainInstance = new Main();
        CustomerService customerInstance = new CustomerService();
        FlightService flightInstance = new FlightService();
        flightInstance.createFlights(airline);
        customerInstance.setCustomers(airline);
        mainMenu(airline, customerInstance, mainInstance, flightInstance);


    }

        public static void mainMenu(Airline airline, CustomerService test, Main testMenu, FlightService run) {
            // customer/manger screen menu
            System.out.println("\nWelcome to MJMC-Airlines!\n\nPlease pick an option from the menu below:");
            boolean loop = false;
            int uInput = 0;
            do {
                boolean correct = true;
                while (correct) {
                    try {
                        uInput = getMenuOptions();
                        correct = false;
                    } catch (InputMismatchException e) {
                        System.out.println("\nInput error. Please choose a number from the options provided.");
                        correct = true;
                    }
                }
                if (uInput == 1) {
                    // if they pick customer, run customer menu
                    test.customerMenu(airline);
                } else if (uInput == 2) {
                    // if they pick manager, run manager menu
                    if (testMenu.managerLogin()) {
                        run.managerMenu(airline);
                    }
                } else {
                    System.out.println("\nInvalid number. Please choose from the options provided.");
                    loop = true;
                }
            } while (loop);
        }


    static int getMenuOptions() {
        // scanner to take terminal input to either customer or manager menu
        Scanner menuScanner = new Scanner(System.in);
        System.out.println("1 - Customer access\n2 - Manager access");
        int numberInput = menuScanner.nextInt();
        return numberInput;
    }

   static  boolean managerLogin() {
        int num = 0;
        Scanner scan = new Scanner(System.in);
        boolean loop1 = true;
        while (loop1) {
            System.out.println("Input manager username:");
            String username = scan.nextLine();
            if (username.equals("Manager")) {
                loop1 = false;
                boolean loop2 = true;
                while (loop2) {
                    System.out.println("Input manager password:");
                    String password = scan.nextLine();
                    if (password.equals("password")) {
                        loop2 = false;
                        num = 1;
                    } else {
                        System.out.println("Don't you remember what your *'password'* is (hint hint)? Try again:");
                    }
                }
            } else {
                System.out.println("Don't you remember what your *'Manager'* username is (hint hint)? Try again:");
            }
        }
        return true;
    }
}
// TO DO LIST

    // FIXED:
        // stop first menu repeating
        // add try - catch to Display booked flights
        // add option to continue after function in manager menu after opt 1
        // add option to continue after function in manager menu after opt 2
        // add option to continue after function in manager menu after opt 3
        // general formatting and menu text changes

        // Added exceptions and loops for input error on main / customer / manager menu

// MAIN:
// * Add initial customer array

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

