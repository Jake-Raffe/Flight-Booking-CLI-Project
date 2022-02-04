package com.bnta;

import com.bnta.customer.CustomerService;
import com.bnta.flights.Airline;
import com.bnta.flights.ManagerService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuService {

    public void mainMenu(Airline airline, CustomerService customerService, ManagerService run, MenuService menuService) {
        // customer/manger screen menu
        System.out.println("\nWelcome to MJMC-Airlines!\n\nPlease pick an option from the menu below:");
        boolean loop = true;
        int uInput = 0;
        while (loop) {
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
                customerService.customerMenu(airline, customerService, run, menuService);
            } else if (uInput == 2) {
                // if they pick manager, run manager menu
                if (managerLogin()) {
                    run.managerMenu(airline, customerService, run, menuService);
                }
            } else if (uInput == 3){
                System.out.println("\nGoodbye");
                break;
            } else {
                    System.out.println("\nInvalid number. Please choose from the options provided.");
                    loop = true;
                }
            }
    }


    static int getMenuOptions() {
        // scanner to take terminal input to either customer or manager menu
        Scanner menuScanner = new Scanner(System.in);
        System.out.println("1 - Customer access\n2 - Manager access\n3 - Quit");
        int numberInput = menuScanner.nextInt();
        return numberInput;
    }

    static boolean managerLogin() {
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
