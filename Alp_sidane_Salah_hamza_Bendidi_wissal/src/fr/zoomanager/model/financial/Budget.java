package fr.zoomanager.model.financial;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe gérant le budget du zoo.
 * Maintient la balance financière et l'historique des transactions.
 * 
 * @see Transaction
 * @see TransactionType
 */
public class Budget {
    /** Balance courante du budget en euros */
    private double balance;
    
    /** Historique des transactions effectuées */
    private List<Transaction> transactions;

    /**
     * Constructeur initialisant un nouveau budget.
     * La balance initiale est à 0 et la liste des transactions est vide.
     */
    public Budget() {
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    /**
     * Ajoute une nouvelle transaction au budget.
     * Met à jour la balance en fonction du montant de la transaction.
     * 
     * @param transaction La transaction à ajouter
     * @throws IllegalArgumentException si la transaction est null
     */
    public void addTransaction(Transaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("La transaction ne peut pas être null");
        }
        transactions.add(transaction);
        this.balance += transaction.getAmount();
    }

    /**
     * Retourne la balance courante du budget.
     * 
     * @return La balance en euros
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Retourne l'historique des transactions.
     * 
     * @return Une copie de la liste des transactions
     */
    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    /**
     * Génère un rapport financier détaillé.
     * Inclut la balance actuelle et les dernières transactions.
     * 
     * @return Le rapport sous forme de chaîne formatée
     */
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== Rapport financier ===\n");
        report.append(String.format("Balance actuelle: %.2f€\n", balance));
        report.append("Dernières transactions:\n");
        
        // Affiche les 5 dernières transactions maximum
        int limit = Math.min(5, transactions.size());
        for (int i = transactions.size() - 1; i >= transactions.size() - limit; i--) {
            report.append(transactions.get(i).toString()).append("\n");
        }
        
        return report.toString();
    }
}
