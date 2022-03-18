package com.bnta;

import com.bnta.customer.CustomerService;
import com.bnta.manager.Airline;
import com.bnta.manager.ManagerService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuService {

    int chooseCorrectMenuNumber() {
        boolean realNumberLoop = true;
        int uInput = 0;
        while (realNumberLoop) {
            try {
                // get input. Break loop if is a number
                uInput = getMenuOptions();
                realNumberLoop = false;
            } catch (InputMismatchException e) {
                // loop if not an integer
                System.out.println("\nInput error. Please choose a number from the options provided.");
                realNumberLoop = true;
            }
        }
        return uInput;
    }

    public void mainMenu(Airline airline, CustomerService customerService, ManagerService run, MenuService menuService) {
        // show customer/manger screen menu
        System.out.println("\nWelcome to MJMC-Airlines!\n\nPlease pick an option from the menu below:");
        // create loop
        boolean correctNumLoop = true;
        while (correctNumLoop) {
            // run is a number checker
            int uInput = chooseCorrectMenuNumber();
            // check if it is a relevant number
            // 1 - customer menu
            if (uInput == 1) {
                customerService.customerMenu(airline, customerService, run, menuService);
                // 2 - manager menu
            } else if (uInput == 2) {
                // if manager log in true > manager menu
                if (managerLogin()) {
                    run.managerMenu(airline, customerService, run, menuService);
                }
            } else if (uInput == 3){
                System.out.println("\nGoodbye");
                break;
            } else {
                    System.out.println("\nInvalid number. Please choose from the options provided.");
                    correctNumLoop = true;
                }
            }
    }

     public int getMenuOptions() {
        // scanner to take terminal input to either customer or manager menu
        Scanner menuScanner = new Scanner(System.in);
        System.out.println("1 - Customer access\n2 - Manager access\n3 - Quit");
        int numberInput = menuScanner.nextInt();
        // return input number
        return numberInput;
    }

    boolean managerLogin() {
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
                        System.out.println("Don't you remember what your *'password'* is (hint hint)? Please try again:");
                    }
                }
            } else {
                System.out.println("Don't you remember what your *'Manager'* username is (hint hint)? Please try again:");
            }
        }
        return true;
    }

}
