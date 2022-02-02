package com.bnta.customer;

import java.util.Scanner;

public class CustomerService {

    public static void main(String[] args) {
       // 1. book new flight
        // 2. view booked flights
        // 3. cancel flight
        // 4. change custom details
        // 5. sign out / end
        newCustomer1();
    }

    //method for adding new customer
    static void newCustomer1(){
        Scanner scanner = new Scanner(System.in);
        Customer newCustomer = new Customer();

        //Customer name scanner
        System.out.println("Enter name:");
        String customerName = scanner.nextLine();
        newCustomer.setName(customerName);

        //customer email scanner
        System.out.println("Enter email:");
        String customerEmail = scanner.nextLine();
        newCustomer.setEmail(customerEmail);

        //customer ID scanner - could be randomised using another method?
        System.out.println("Enter ID:");
        int customerID = scanner.nextInt();
        newCustomer.setId(customerID);

        //customer passport number scanner
        System.out.println("Enter Passport Number:");
        int passportNumber = scanner.nextInt();
        newCustomer.setPassportNumber(passportNumber);
    }

}
