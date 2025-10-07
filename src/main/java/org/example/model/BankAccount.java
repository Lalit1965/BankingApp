package org.example.model;

// Simple data model for a bank account
public class BankAccount {
    private int accountNumber; // unique account number
    private String accountHolder; // account owner's name
    private double balance; // current balance

    // Constructor to initialize an account object
    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getters for private fields
    public int getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }
}
