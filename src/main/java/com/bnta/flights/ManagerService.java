package com.bnta.flights;

import com.bnta.MenuService;
import com.bnta.customer.Customer;
import com.bnta.customer.CustomerService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagerService {
    //1. managerMenu
    //2. While Loop in menus so they can do multiple functions
    //3. Throw error message if user chooses wrong option
    // service methods for manager business logic



    public void managerMenu(Airline airline, CustomerService customerInstance, ManagerService flightInstance, MenuService mainInstance){
    System.out.println("\nWelcome manager. Please select an option from the menu below:");
    boolean loop = true;
    int uInput = 0;
        while(loop) {
            boolean correct = true;
            while (correct) {
                try {
                    uInput = getFlightService();
                    correct = false;
                } catch (InputMismatchException e) {
                    System.out.println("\nInput error. Please choose a number from the options provided.");
                    correct = true;
                }
            }
            // booked flights
            if (uInput == 1) {
                try {
                    loop = true;
                    getBookedFlights(airline);
                    System.out.println("\nWould you like to use another service?\n(y - Yes / n - No)");
                    Scanner scan = new Scanner(System.in);
                    String input = scan.nextLine();
                    if (input.equals("y")) {
                    } else if (input.equals("n")) {
                        loop = false;
                    } else {
                        System.out.println("Sorry, please choose from the options provided (y - Yes / n - No).");
                        input = scan.nextLine();}
                } catch (NullPointerException e) {
                    loop = true;
                    System.out.println(" \nNo flights currently booked.");
                } System.out.println("\nWould you like to use another service?\n(y - Yes / n - No)");
                    Scanner scan = new Scanner(System.in);
                    String input = scan.nextLine();
                    if (input.equals("y")) {
                    } else if (input.equals("n")) {
                        loop = false;
                    } else {
                        System.out.println("\nSorry, please choose from the options provided (y - Yes / n - No).");
                        input = scan.nextLine();
                    }
                }
            // available flights
            else if (uInput == 2) {
                loop = true;
                displayAllFlights(airline);
            System.out.println(" \nWould you like to use another service?\n(y - Yes / n - No)");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            if (input.equals("y")) {
            } else if (input.equals("n")) {
                loop = false;
            } else {
                System.out.println(" \nSorry, please choose from the options provided (y - Yes / n - No).");
                input = scan.nextLine();
            }
            // flight by customer id
            }
            else if (uInput == 3) {
                try {
                    loop = true;
                    displayFlightById(airline);
                    System.out.println(" \nWould you like to use another service?\n(y - Yes / n - No)");
                    Scanner scan = new Scanner(System.in);
                    String input = scan.nextLine();
                    if (input.equals("y")) {
                    } else if (input.equals("n")) {
                        loop = false;
                    } else {
                        System.out.println("\nSorry, please choose from the options provided (y - Yes / n - No).");
                        input = scan.nextLine();
                    }
                } catch (NullPointerException e) {
                    loop = true;
                    System.out.println("\nNo customers currently booked.");
                    System.out.println(" \nWould you like to use another service?\n(y - Yes / n - No)");
                    Scanner scan = new Scanner(System.in);
                    String input = scan.nextLine();
                    if (input.equals("y")) {
                    } else if (input.equals("n")) {
                        loop = false;
                    } else {
                        System.out.println("\nSorry, please choose from the options provided (y - Yes / n - No).");
                        input = scan.nextLine();
                    }
                }
                // exit
            } else if (uInput == 4){
                // return to main menu
                mainInstance.mainMenu(airline, customerInstance, flightInstance, mainInstance);
                    loop = false;
                } else {
                    System.out.println("\nInvalid number. Please choose from the options provided.");
                }
            }
        }


    public int getFlightService() {
        Scanner flightScanner = new Scanner(System.in);
        System.out.println("1 - Display flight-numbers of booked flights\n2 - Display flight-numbers of all available flights\n3 - Display flight by customer ID\n4 - Return to access menu");
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
        System.out.println(" \nAvailable flights: ");
        // 2. loop through all flights and print flight number
        for (Flights f : airline.getFlights()) {
            System.out.print(f.getFlightNumber() + ", ");
        }

    }
    public void displayFlightById(Airline airline){
        // 1. make scanner to take customer ID
        System.out.println(" \nPlease input customer ID number: ");
        // 2. find customer from ID value with try-catch for non int input and for not found
        boolean loop = true;
        boolean worked = false;
        int id= 0;
        while (loop) {
        Scanner scanner = new Scanner(System.in);
        try {
            id = scanner.nextInt();
            loop = false;
            worked = true;
        } catch (InputMismatchException e){
            System.out.println("\nInput error. Please enter a valid ID number:");
            loop = true;
            worked = false;
        }
        if (worked) {
            int num = 0;
            Customer[] customers = airline.getCustomers();
            for (Customer c :
                    customers) {
                num = c.getId();
                if (id == num) {
                    // 3. find customer's flight and print
                    Flights flight = c.getFlight();
                    System.out.println("Customer " + id + " flight is: " + flight);
                } else {
                    System.out.println("Customer ID not found.");
                }
            }
        }
        }
    }

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
}
