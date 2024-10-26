package pl.mbaranowski._0_core;

import java.util.Objects;

public class TransferRequestPOJO {
    private String from;
    private String to;
    private long amount;
    private String transferId;

    public TransferRequestPOJO() {
    }

    public TransferRequestPOJO(String from, String to, long amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        transferId = "transferId";
    }

    public TransferRequestPOJO(String from, String to, long amount, String transferId) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.transferId = transferId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getTransferId() {
        return transferId;
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferRequestPOJO that = (TransferRequestPOJO) o;
        return amount == that.amount && Objects.equals(from, that.from) && Objects.equals(to, that.to) && Objects.equals(transferId, that.transferId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, amount, transferId);
    }
}
