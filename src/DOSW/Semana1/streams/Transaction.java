package DOSW.Semana1.streams;

public class Transaction {
    String id;
    double amount;
    boolean approved;

    public Transaction(String id, double amount, boolean approved) {
        this.id = id;
        this.amount = amount;
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "Transaction{id='" + id + "', amount=" + amount + ", approved=" + approved + '}';
    }
}