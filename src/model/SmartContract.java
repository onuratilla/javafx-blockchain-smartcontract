package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SmartContract {
    private List<Transaction> pendingTransactions = new ArrayList<>();

    public void createTransaction(Transaction tx) {
        pendingTransactions.add(tx);
    }

    public void approveTransaction(String walletAddress, String txId) {
        for (Transaction tx : pendingTransactions) {
            if (tx.getId().equals(txId)) {
                if (walletAddress.equals(tx.getFromAddress())) {
                    tx.setFromApproved(true);
                } else if (walletAddress.equals(tx.getToAddress())) {
                    tx.setToApproved(true);
                }
            }
        }
    }

    public List<Transaction> getApprovedTransactions() {
        return pendingTransactions.stream()
                .filter(tx -> tx.isFullyApproved() && !tx.isExpired())
                .collect(Collectors.toList());
    }

    public void removeExpiredTransactions() {
        pendingTransactions.removeIf(Transaction::isExpired);
    }

    public List<Transaction> getAllPending() {
        return new ArrayList<>(pendingTransactions);
    }
}