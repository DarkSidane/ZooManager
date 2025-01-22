package fr.zoomanager.model.financial;

/**
 * Énumération représentant les différents types de transactions possibles.
 * Permet de distinguer les entrées (revenus) et les sorties (dépenses) d'argent.
 */
public enum TransactionType {
    /** Transaction entrante (revenus). */
    INCOME("€+"),
    
    /** Transaction sortante (dépenses). */
    EXPENSE("€-");

    /** Symbole associé au type de transaction. */
    private final String symbol;

    /**
     * Constructeur du type de transaction.
     * 
     * @param symbol Symbole représentant le type de transaction.
     */
    TransactionType(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Retourne le symbole associé au type de transaction.
     * 
     * @return Le symbole (€+ pour les revenus, €- pour les dépenses).
     */
    public String getSymbol() {
        return symbol;
    }
}
