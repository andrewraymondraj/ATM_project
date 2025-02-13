package practice;

import java.util.Scanner;

public class ATMSimulation {
    private static int PIN = 1234;  // Default PIN
    private static double balance = 1000.00;  

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 3;  // Maximum PIN attempts

        System.out.println("Welcome to the ATM!");

       
        while (attempts > 0) {
        	
            System.out.print("Enter your PIN: ");
            int enteredPin = scanner.nextInt();

            if (enteredPin == PIN) {
                System.out.println("PIN verified successfully!");
                atmMenu(scanner);
                break;
            } else {
                attempts--;
                System.out.println("Incorrect PIN. Attempts left: " + attempts);
            }

            if (attempts == 0) {
                System.out.println("Too many incorrect attempts. Exiting...");
                scanner.close();
                return;
            }
        }
    }

    private static void atmMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    changePin(scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: Rs" + balance);
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: Rs");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited Rs" + amount);
            checkBalance();
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private static void withdraw(Scanner scanner) {
    	System.out.println("Your current balance is: Rs" + balance);
        System.out.print("Enter amount to withdraw: Rs");
        double amount = scanner.nextDouble();
        

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew Rs" + amount);
            checkBalance();
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
    private static void changePin(Scanner scanner) {
        System.out.print("Enter your current PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin == PIN) {
            System.out.print("Enter new PIN: ");
            int newPin = scanner.nextInt();
            System.out.print("Confirm new PIN: ");
            int confirmPin = scanner.nextInt();

            if (newPin == confirmPin) {
                PIN = newPin;
                System.out.println("PIN changed successfully!");
            } else {
                System.out.println("PINs do not match. Try again.");
            }
        } else {
            System.out.println("Incorrect current PIN. Returning to menu.");
        }
    }
}
