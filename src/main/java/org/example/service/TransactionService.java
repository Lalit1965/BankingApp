package org.example.service;

import org.example.model.Transaction;
import org.example.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Handles transaction logging and retrieval
public class TransactionService {

    // Inserts a transaction record into the database
    public void logTransaction(int accountNumber, String type, double amount) throws SQLException {
        String sql = "INSERT INTO Transactions (accountNumber, type, amount) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, accountNumber);
            ps.setString(2, type);
            ps.setDouble(3, amount);
            ps.executeUpdate();
        }
    }

    // Get all transactions for a specific account (newest first)
    public List<Transaction> getTransactions(int accountNumber) throws SQLException {
        String sql = "SELECT * FROM Transactions WHERE accountNumber = ? ORDER BY timestamp DESC";
        List<Transaction> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, accountNumber);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Transaction(
                            rs.getInt("id"),
                            rs.getInt("accountNumber"),
                            rs.getString("type"),
                            rs.getDouble("amount"),
                            rs.getTimestamp("timestamp")
                    ));
                }
            }
        }
        return list;
    }
}
