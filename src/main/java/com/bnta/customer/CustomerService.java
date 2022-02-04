package com.bnta.customer;
import java.util.InputMismatchException;
import java.util.Random;

import com.bnta.MenuService;
import com.bnta.flights.Airline;
import com.bnta.flights.FlightNumber;
import com.bnta.flights.Flights;
import com.bnta.flights.ManagerService;

import java.util.Scanner;

public class CustomerService {

       // 1. book new flight
        // 2. view booked flights
        // 3. cancel flight
        // 4. sign out / end
    public void customerMenu(Airline airline, CustomerService customerInstance, ManagerService flightInstance, MenuService mainInstance){
        System.out.println("\nWelcome, valued customer!\nPlease select an option from the menu below:");
        boolean loop = true;
        int uInput = 0;
        while(loop) {
            boolean correct = true;
            while (correct) {
                try {
                    uInput = getCustomerOptions();
                    correct = false;
                } catch (InputMismatchException e) {
                    System.out.println("\nInput error. Please choose a number from the options provided.");
                    correct = true;
                }
            }
            if (uInput == 1) {
                Customer newCustomer = newCustomer1(airline);
                bookFlightOption(airline, newCustomer);
                System.out.println("\nYour flight has been booked.\nWould you like to use another service?\n(y - Yes / n - No)");
                Scanner scan = new Scanner(System.in);
                String input = scan.nextLine();
                if (input.equals("y")) {
                } else if (input.equals("n")) {
                    loop = false;
                } else {
                    System.out.println("Sorry, please choose from the options provided (y - Yes / n - No).");
                    input = scan.nextLine();
                }
            } else if (uInput == 2) {
                try {
                    displayFlightById(airline);
                    loop = false;
                } catch (Exception e){
                    System.out.println("ID number not found.");
                }
                System.out.println("\nWould you like to use another service?\n(y - Yes / n -No)");
                Scanner scan = new Scanner(System.in);
                String input = scan.nextLine();
                if (input.equals("y")) {
                } else if (input.equals("n")) {
                    loop = false;
                } else {
                    System.out.println("Sorry, please choose from the options provided (y - Yes / n - No).");
                    input = scan.nextLine();
                }
            } else if (uInput == 3) {
                //cancelFlight();
                loop = false;
            } else if(uInput == 4){
                // return to main menu
                mainInstance.mainMenu(airline, customerInstance, flightInstance, mainInstance);
                loop = false;
            }
            else {
                System.out.println("\nInvalid number. Please choose from the options provided.");
            }
        }
    }
    // Customer menu screen
    public static int getCustomerOptions() {
        Scanner flightScanner = new Scanner(System.in);
        System.out.println("1 - Book new flight\n2 - View existing booking\n3 - Cancel booked flight \n4 - Return to access menu");
        int numberInput = flightScanner.nextInt();
        return numberInput;
    }
    //method for adding new customer
    public static Customer newCustomer1(Airline airline){
        Scanner scanner = new Scanner(System.in);
        Customer newCustomer = new Customer("","",0,0,0,null,null);

        //Customer name scanner
        System.out.println("Enter name:");
        String customerName = scanner.nextLine();
        newCustomer.setName(customerName);

        //customer email scanner
        System.out.println("Enter email:");
            // validate email to see if it contains '@'
        String customerEmail = validateEmail();
        newCustomer.setEmail(customerEmail);

        //Random number generator method to assign random number to new customer ID
        newCustomer.setId(randomIDGenerator(airline));

        //customer passport number scanner
        System.out.println("Enter Passport Number:");
        boolean correct = true;
        int passportNumber = 0;
        while (correct) {
            try {
                passportNumber = scanner.nextInt();
                correct = false;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter passport number");
                correct = true;
            }
        }
        newCustomer.setPassportNumber(passportNumber);

        //customer phone number scanner
        System.out.println("Enter phone Number:");
        correct = true;
        int phoneNumber = 0;
        while (correct) {
            try {
                phoneNumber = scanner.nextInt();
                correct = false;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter passport number");
                correct = true;
            }
        }
        newCustomer.setPhoneNumber(phoneNumber);

        //while loop to add customers luggage size and convert string input into Enum property
        boolean sizeDeclared = true;
        while (sizeDeclared){
           luggageSize();
           Scanner scanner2 = new Scanner(System.in);
           String luggage = scanner2.nextLine();
            switch (luggage){
              case "Small":
                newCustomer.setLuggage(Luggage.SMALL);
                sizeDeclared = false;
                break;
              case "Medium":
                newCustomer.setLuggage(Luggage.MEDIUM);
                  sizeDeclared = false;
                break;
             case "Large":
                newCustomer.setLuggage(Luggage.LARGE);
                 sizeDeclared = false;
                break;
             case "No Luggage":
                newCustomer.setLuggage(Luggage.NONE);
                 sizeDeclared = false;
                break;
            default:
                System.out.println("Not a valid option. Try again.");
        }
        }
        return newCustomer;
//       //print to check customer info:
//        System.out.println(newCustomer);
    }

    //method to ask luggage size question
    public static void luggageSize(){
        System.out.println("What size is your luggage (Small, Medium, Large, or No Luggage)?");
    }

    public static int randomIDGenerator(Airline airline) {
        Random rand = new Random();
        //generate random number 0-100
        int upperBound = 20;
        int int_random = rand.nextInt(upperBound);
        // if no other customers then ID is unique
        Customer[] customers = airline.getCustomers();
        boolean uniqueID = true;
        if (airline.getCustomers() != null){
            // if other customers, check that new ID is unique
        while (uniqueID) {
            for (Customer c : customers) {
                if (int_random == c.getId()) {
                    int_random = rand.nextInt(upperBound);
                } else {
                    uniqueID = false;
                }
            }
        }}
        return int_random;
    }

            //method to check for valid email
            public static String validateEmail() {
                boolean validEmail = true;
                String customerEmail = "";
            Scanner scanner = new Scanner(System.in);
                while (validEmail) {
                     customerEmail = scanner.nextLine();
                        if (customerEmail.contains("@")) {//if email contains @ sign then loop breaks and program continues
                            validEmail = false;
                        break;
                    } else { //if email does not contain @ then validEmail is false and while loop repeats
                        System.out.println("Error. Please input valid: ");
                    }
                }
                return customerEmail;
            }

            public static void displayFlightById(Airline airline){
                System.out.println("\nEnter Customer ID number to see booked flight:  ");
                Scanner scanner = new Scanner(System.in);
                int customerID = scanner.nextInt();
                for (Customer customer: airline.getCustomers()){
                    if (customerID == customer.getId()){
                        System.out.println("Customer " + customerID + " flight: " + customer.getFlight());
                    }
                    else System.out.println("Invalid ID number.");
                }
            }

            //method to display all flights
            public static void displayAllFlights(Airline airline){
            Airline flights = new Airline();
                System.out.println(flights.getFlights());
            }

            //method to quit. Double checks if user wants to quit. Exits program if yes, goes back to customer menu if no.
//            public static void quitMethod(){
//                System.out.println("Are you sure you want to quit program? \n(y - Yes / n - No, use another service)");
//                Scanner scan = new Scanner(System.in);
//                String input = scan.nextLine();
//                if (input.equals("y")){
//                    //quit method
//                    System.exit(0);
//                } else if (input.equals("n")) {
//                    getCustomerOptions();
//                } else {
//                    System.out.println("\nSorry, please choose from the options provided (y - Yes / n - No).");
//                    input = scan.nextLine();
//                }
//            }

            //method to book a flight
            public static void bookFlightOption(Airline airline, Customer customer) {
                // get flights
                Flights[] flightArr = airline.getFlights();
                // for each flight, print the flight number
                System.out.println("\nPlease type the flight number of the flight you wish to book from the list below:\n");
                for (Flights f :
                        flightArr) {
                    System.out.print(f.getFlightNumber() + ", ");
                }
                System.out.println("\n");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                Flights chosenFlight = new Flights();
                // loop to check input against available flights
                for (int i = 0; i < flightArr.length; i++) {
                    String number = flightArr[i].getFlightNumber().name();
                    if (input.equals(number)){
                        chosenFlight = flightArr[i];
                        customer.setFlight(chosenFlight);
                        System.out.println("Booking confirmed!");
                        break;
                    } else {
                        System.out.println("Incorrect number.");
                        break;
                    }
                }
            }

                public void setCustomers(Airline airline){
                    Customer[] customersArr = new Customer[10];
                    Flights[] flightOptions = airline.getFlights();
                    Customer michael = new Customer("Michael","michaelontime@gmail.com", 24, 1234, 8762, Luggage.MEDIUM, flightOptions[0]);
                    customersArr[0] = michael;

                    Customer marcy = new Customer("Marcy", "marcy@gmail.com", 18, 3245, 7676, Luggage.LARGE, flightOptions[1]);
                    customersArr[1] = marcy;

                    Customer jake = new Customer("Jake", "Jakeneuro@gmail.com", 46, 4532, 9812, Luggage.LARGE, flightOptions[2]);
                    customersArr[2] = jake;

                    Customer connie = new Customer("Connie", "connieconnnie@gmail.com", 28, 6788, 8243, Luggage.NONE, flightOptions[3]);
                    customersArr[3] = connie;
    }


            }