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
    // 4. change custom details
    // 5. sign out / end
    // Management options
    // sign in
    // 1. add new flight
    // 2. display all available flights
    // 3. display all booked flights
    // 4. display flights for a specific user
    // 5. book a flight for a specific user ID
    // 6. change flight details
    // 7. remove a flight
    //8. sign out / end

    //classes
    // POJOs
    // 1. customers/ user
    // name
    // email
    // id (random generator)
    // phone number
    // passport number?
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
        getMenuOptions();
        boolean loop = true;
        while (loop) {
            int uInput = getMenuOptions();
            if (uInput == 1) {
                // if they pick customer, run customer menu
                test.customerMenu(airline);
                loop = false;
            } else if (uInput == 2) {
                // if they pick manager, run manager menu
                if(testMenu.managerLogin()){
                run.managerMenu(airline);
                loop = false;}
            } else {
                System.out.println("Sorry, please choose from the options provided.");
            }
        }

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
                System.out.println("Don't you remember what your *'Username'* is (hint hint)? Try again:");
            }
        }
        return true;
    }
}
// TO DO LIST
// stop first menu repeating
// customer menu repeats on quit
// give option to continue after function in manager menu
// customer display all flights doesn't work
// after inputing customer details, flight is not booked
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

