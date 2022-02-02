package com.bnta.customer;

import java.util.Scanner;

public class CustomerService {

    public static void main(String[] args) {
       // 1. book new flight
        // 2. view booked flights
        // 3. cancel flight
        // 4. change custom details
        // 5. sign out / end
    }

    static void newCustomer1(){
        Scanner scanner = new Scanner(System.in);
        Customer newCustomer = new Customer();
        System.out.println("Enter name:");
        String customerName = scanner.nextLine();
        newCustomer.getName() = customerName

    }

//    static String newCustomer(){
//    Scanner scanner = new Scanner(System.in);
//    String input = scanner.nextLine();
//
//
//        return Customer;
//    }
}
