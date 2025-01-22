package fr.zoomanager.model.financial;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe représentant une transaction financière dans le zoo.
 * Une transaction est immuable une fois créée.
 * 
 * @see Budget
 * @see TransactionType
 */
public class Transaction {
    /** Montant de la transaction en euros */
    private final double amount;
    
    /** Description de la transaction */
    private final String description;
    
    /** Date et heure de la transaction */
    private final LocalDateTime date;
    
    /** Type de la transaction (entrée ou sortie) */
    private final TransactionType type;

    /**
     * Constructeur d'une nouvelle transaction.
     * 
     * @param amount Montant de la transaction
     * @param description Description de la transaction
     * @param type Type de la transaction
     * @throws IllegalArgumentException si la description est null ou vide
     */
    public Transaction(double amount, String description, TransactionType type) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("La description ne peut pas être vide");
        }
        this.amount = amount;
        this.description = description;
        this.date = LocalDateTime.now();
        this.type = type;
    }

    /**
     * Retourne le montant de la transaction.
     * 
     * @return Le montant en euros
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Retourne la description de la transaction.
     * 
     * @return La description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retourne la date et l'heure de la transaction.
     * 
     * @return La date et l'heure
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Retourne le type de la transaction.
     * 
     * @return Le type (INCOME ou EXPENSE)
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * Retourne une représentation textuelle de la transaction.
     * Format : [date] +/-montant€ - description
     * 
     * @return La transaction formatée
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String sign = amount >= 0 ? "+" : "";
        return String.format("[%s] %s%s%.2f€ - %s", 
            date.format(formatter), sign, type.getSymbol(), amount, description);
    }
}
