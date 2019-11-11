public class FundTransfer {

    private int fromId;
    private int toId;
    private double amount;

    public FundTransfer(int fromId, int toId, double amount) {
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
    }

    public int getFromId() {
        return fromId;
    }

    public int getToId() {
        return toId;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "FundTransfer{" +
                "fromId=" + fromId +
                ", toId=" + toId +
                ", amount=" + amount +
                '}';
    }
}