package org.example.model;

import java.sql.Timestamp;

// Represents a financial transaction for an account
public class Transaction {
    private int id; // unique transaction ID
    private int accountNumber; // linked account
    private String type; // "deposit" or "withdraw"
    private double amount; // amount of transaction
    private Timestamp timestamp; // when transaction occurred

    public Transaction(int id, int accountNumber, String type, double amount, Timestamp timestamp) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    // Getters
    public int getId() {
        return id;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public String getType() {
        return type;
    }
    public double getAmount() {
        return amount;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
}
