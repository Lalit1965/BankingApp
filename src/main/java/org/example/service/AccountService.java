package org.example.service;

import org.example.model.BankAccount;
import org.example.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Handles all database operations related to bank accounts
public class AccountService {

    // Create a new account in the database
    public boolean createAccount(int accountNumber, String holder, double balance) throws SQLException {
        // Check if account already exists
        String checkSql = "SELECT * FROM Accounts WHERE accountNumber = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement checkPs = conn.prepareStatement(checkSql)) {

            checkPs.setInt(1, accountNumber);
            try (ResultSet rs = checkPs.executeQuery()) {
                if (rs.next()) {
                    System.out.println("❌ Account number already exists. Try another.");
                    return false;
                }
            }

            // Insert new account
            String sql = "INSERT INTO Accounts (accountNumber, accountHolder, balance) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, accountNumber);
                ps.setString(2, holder);
                ps.setDouble(3, balance);
                ps.executeUpdate();
                System.out.println("✅ Account created for " + holder + " (Account #: " + accountNumber + ")");
                return true;
            }
        }
    }

    // Return a list of all accounts
    public List<BankAccount> listAccounts() throws SQLException {
        String sql = "SELECT * FROM Accounts";
        List<BankAccount> accounts = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                accounts.add(new BankAccount(
                        rs.getInt("accountNumber"),
                        rs.getString("accountHolder"),
                        rs.getDouble("balance")
                ));
            }
        }
        return accounts;
    }

    // Fetch a single account by its number
    public BankAccount getAccount(int accountNumber) throws SQLException {
        String sql = "SELECT * FROM Accounts WHERE accountNumber = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, accountNumber);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new BankAccount(
                            rs.getInt("accountNumber"),
                            rs.getString("accountHolder"),
                            rs.getDouble("balance")
                    );
                }
            }
        }
        return null; // account not found
    }

    // Deposit money into account
    public void deposit(int accountNumber, double amount) throws SQLException {
        String sql = "UPDATE Accounts SET balance = balance + ? WHERE accountNumber = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, amount);
            ps.setInt(2, accountNumber);
            ps.executeUpdate();
            System.out.println("💰 Deposited $" + amount);
        }
    }

    // Withdraw money from account
    public void withdraw(int accountNumber, double amount) throws SQLException {
        BankAccount acc = getAccount(accountNumber);
        if (acc == null) {
            System.out.println("Account was not found.");
            return;
        }
        if (acc.getBalance() < amount) {
            System.out.println("Insufficient balance.");
            return;
        }

        String sql = "UPDATE Accounts SET balance = balance - ? WHERE accountNumber = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, amount);
            ps.setInt(2, accountNumber);
            ps.executeUpdate();
            System.out.println("💰 Withdrawn $" + amount);
        }
    }
}
