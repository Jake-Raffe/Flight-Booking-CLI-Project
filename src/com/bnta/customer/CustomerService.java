package com.bnta.customer;
import java.util.Random;
import com.bnta.flights.Airline;
import com.bnta.flights.Flights;

import java.util.Scanner;

public class CustomerService {

       // 1. book new flight
        // 2. view booked flights
        // 3. cancel flight
        // 4. change custom details
        // 5. sign out / end
    public void customerMenu(Airline airline){
        System.out.println("Welcome! Please select an option from the menu below:");
        getCustomerOptions();
        boolean loop = true;
        while(loop) {
            int uInput = getCustomerOptions();
            if (uInput == 1) {
                newCustomer1(airline);
                bookFlightOption();
                System.out.println("Your flight has been booked.\nWould you like to use another service?\n(y - Yes / n - No)");
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
                displayAllFlights(airline);
                loop = false;
            } else if (uInput == 3) {
                displayFlightById(airline);
                loop = false;
            } else if(uInput ==4){
                //quitMethod
                loop = false;
            }
            else {
                System.out.println("Sorry input not recognised. Try again...");
            }
        }
    }

    public static int getCustomerOptions() {
        Scanner flightScanner = new Scanner(System.in);
        System.out.println("1 - Book new flight\n2 - View existing booking\n3 -Display all flights \n4 - Quit");
        int numberInput = flightScanner.nextInt();
        return numberInput;
    }
    //method for adding new customer
    public static void newCustomer1(Airline airline){
        Scanner scanner = new Scanner(System.in);
        Customer newCustomer = new Customer();

        //Customer name scanner
        System.out.println("Enter name:");
        String customerName = scanner.nextLine();
        newCustomer.setName(customerName);

        //customer email scanner
        System.out.println("Enter email:");
        String customerEmail = validateEmail();
        newCustomer.setEmail(customerEmail);

        //Random number generator method to assign random number to new customer ID
        newCustomer.setId(randomIDGenerator(airline));

        //customer passport number scanner
        System.out.println("Enter Passport Number:");
        int passportNumber = scanner.nextInt();
        newCustomer.setPassportNumber(passportNumber);

        //customer phone number scanner
        System.out.println("Enter phone Number:");
        int phoneNumber = scanner.nextInt();
        newCustomer.setPhoneNumber(phoneNumber)

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
        // check if ID has already been assigned
        Customer[] customers = airline.getCustomers();
        boolean uniqueID = true;
        if (airline.getCustomers() != null){
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
                        if (customerEmail.contains("@")) {
                        System.out.println("Thank you."); //if email contains @ sign then loop breaks and program continues
                            validEmail = false;
                        break;
                    } else { //if email does not contain @ then validEmail is false and while loop repeats
                        System.out.println("Unknown email. Try again: ");
                    }
                }
                return customerEmail;
            }

            public static void displayFlightById(Airline airline){
                System.out.println("Enter Customer ID number to see flight bookings:  ");
                Scanner scanner = new Scanner(System.in);
                int customerID = scanner.nextInt();
                for (Customer customer: airline.getCustomers()){
                    if (customerID == customer.getId()){
                        System.out.println(customer.getFlight());
                    }
                    else System.out.println("Invalid ID number.");
                }
            }

            //method to display all flights
            public static void displayAllFlights(Airline airline){
            Airline flights = new Airline();
                System.out.println(flights.getFlights());
            }

            public static void quitMethod(){
                System.out.println("Are you sure you want to quit program? \n(y - Yes / n - No, use another service)");
                Scanner scan = new Scanner(System.in);
                String input = scan.nextLine();
                if (input.equals("y")) {
                    //quit program
                } else if (input.equals("n")) {
                    getCustomerOptions();
                } else {
                    System.out.println("Sorry, please choose from the options provided (y - Yes / n - No).");
                    input = scan.nextLine();
                }


            }

            public static void bookFlightOption(){
                Airline flights = new Airline();
                System.out.println(flights.getFlights());
                System.out.println("Please select ");


            }
}

        // make method where they find customer id by putting in other details