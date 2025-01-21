package fr.zoomanager.model.financial;

public enum TransactionType {
    INCOME("€+"),
    EXPENSE("€-");

    private final String symbol;

    TransactionType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
