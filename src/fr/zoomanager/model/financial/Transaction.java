package fr.zoomanager.model.financial;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final double amount;
    private final String description;
    private final LocalDateTime date;
    private final TransactionType type;

    public Transaction(double amount, String description, TransactionType type) {
        this.amount = amount;
        this.description = description;
        this.date = LocalDateTime.now();
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public TransactionType getType() {
        return type;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String sign = amount >= 0 ? "+" : "";
        return String.format("[%s] %s%s%.2f€ - %s", 
            date.format(formatter), sign, type.getSymbol(), amount, description);
    }
}
