package com.bnta;

import com.bnta.customer.CustomerService;
import com.bnta.flights.Airline;
import com.bnta.flights.FlightService;

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
    // DAO
    // flightDAO
    // customerDAO
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
        Main testMenu = new Main();
        CustomerService test = new CustomerService();
        FlightService run = new FlightService();
        run.createFlights(airline);


        // customer/manger screen menu
        boolean loop = false;
        do {
            int uInput = getMenuOptions();
            if (uInput == 1) {
                // if they pick customer, run customer menu
                test.customerMenu(airline);
            } else if (uInput == 2) {
                // if they pick manager, run manager menu
                if(testMenu.managerLogin()){
                run.managerMenu(airline);
                    }
            } else {
                System.out.println("Sorry, please choose from the options provided.");
                loop = true;
            }
        } while (loop);
    }

    static int getMenuOptions() {
        // scanner to take terminal input to either customer or manager menu
        System.out.println("Welcome to MJMC-Airlines!\nPlease pick an option from the menu below:");
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

// MANAGER FIXES:
// add try catch in customer ID number (manager menu) for inputMismatchException
// managerMenu customerID ask if they want to use another service after No customers booked
// add return to access menu in manager menu and customer menu
// CUSTOMER FIXES:
// customer menu repeats on quit
// picking an option from menu repeats menu the first time
// after inputing customer details, flight is not booked
// 2 - view existing booking: add null pointer exception for no customer (take from manager) / add wrong format try catch
// 1 - create booking: make booking method

// customer display all flights doesn't work

// add exceptions to menus for inproper input format
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

