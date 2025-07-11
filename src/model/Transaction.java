package model;

import java.util.UUID;

public class Transaction {
    private String id;
    private String fromAddress;
    private String toAddress;
    private double amount;
    private long timestamp;
    private long expiryTimestamp;
    private boolean fromApproved = false;
    private boolean toApproved = false;

    public Transaction(String from, String to, double amount) {
        this.id = UUID.randomUUID().toString();
        this.fromAddress = from;
        this.toAddress = to;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();
        this.expiryTimestamp = this.timestamp + 5 * 60 * 1000;
    }

    public boolean isFullyApproved() {
        return fromApproved && toApproved;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiryTimestamp;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getFromAddress() { return fromAddress; }
    public String getToAddress() { return toAddress; }
    public double getAmount() { return amount; }
    public boolean isFromApproved() { return fromApproved; }
    public boolean isToApproved() { return toApproved; }
    public void setFromApproved(boolean value) { fromApproved = value; }
    public void setToApproved(boolean value) { toApproved = value; }
}