package org.example.main;

import org.example.model.BankAccount;
import org.example.service.AccountService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner to read user input from console
        Scanner scanner = new Scanner(System.in);

        // AccountService instance handles all account-related operations
        AccountService accountService = new AccountService();

        // Main menu loop
        while (true) {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. List Accounts");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline character

            try {
                if (choice == 1) { // Create a new account
                    System.out.print("Enter account number: ");
                    int accNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double amount = scanner.nextDouble();

                    boolean success = accountService.createAccount(accNum, name, amount);
                    if (!success) {
                        System.out.println("Failed to create account. Try again with a different account number.");
                    }

                } else if (choice == 2) { // List all accounts
                    List<BankAccount> accounts = accountService.listAccounts();
                    System.out.println("\nAccountNumber | Holder | Balance");
                    for (BankAccount acc : accounts) {
                        System.out.println(acc.getAccountNumber() + " | " + acc.getAccountHolder() + " | " + acc.getBalance());
                    }

                } else if (choice == 3) { // Deposit money
                    System.out.print("Enter account number: ");
                    int acc = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double amt = scanner.nextDouble();
                    accountService.deposit(acc, amt);
                    BankAccount updated = accountService.getAccount(acc);
                    if (updated != null) {
                        System.out.println("💰 New balance: $" + updated.getBalance());
                    }

                } else if (choice == 4) { // Withdraw money
                    System.out.print("Enter account number: ");
                    int acc = scanner.nextInt();
                    System.out.print("Enter withdraw amount: ");
                    double amt = scanner.nextDouble();
                    accountService.withdraw(acc, amt);
                    BankAccount updated = accountService.getAccount(acc);
                    if (updated != null) {
                        System.out.println("💰 Current balance: $" + updated.getBalance());
                    }

                } else if (choice == 5) { // Exit program
                    System.out.println("Exiting...");
                    break;

                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            } catch (SQLException e) { // Catch any SQL errors from service layer
                System.out.println("Database error: " + e.getMessage());
            }
        }

        scanner.close(); // Close Scanner to free resources
    }
}
