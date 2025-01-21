package fr.zoomanager.model.financial;

import java.util.ArrayList;
import java.util.List;

public class Budget {
    private double balance;
    private List<Transaction> transactions;

    public Budget() {
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        this.balance += transaction.getAmount();
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== Rapport financier ===\n");
        report.append(String.format("Balance actuelle: %.2f€\n", balance));
        report.append("Dernières transactions:\n");
        
        int limit = Math.min(5, transactions.size());
        for (int i = transactions.size() - 1; i >= transactions.size() - limit; i--) {
            report.append(transactions.get(i).toString()).append("\n");
        }
        
        return report.toString();
    }
}
