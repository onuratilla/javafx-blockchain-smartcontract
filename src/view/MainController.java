package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

public class MainController {

    @FXML private TextField fromField, toField, amountField;
    @FXML private TextField approveWalletField, approveTxField;
    @FXML private TableView<Transaction> transactionTable;
    @FXML private TableColumn<Transaction, String> colId, colFrom, colTo;
    @FXML private TableColumn<Transaction, Double> colAmount;
    @FXML private TableColumn<Transaction, Boolean> colFromApproved, colToApproved;

    private SmartContract contract = new SmartContract();
    private ObservableList<Transaction> txList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getId()));
        colFrom.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getFromAddress()));
        colTo.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getToAddress()));
        colAmount.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getAmount()));
        colFromApproved.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().isFromApproved()));
        colToApproved.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().isToApproved()));
        transactionTable.setItems(txList);
    }

    @FXML
    public void handleCreateTransaction() {
        String from = fromField.getText();
        String to = toField.getText();
        double amount = Double.parseDouble(amountField.getText());
        Transaction tx = new Transaction(from, to, amount);
        contract.createTransaction(tx);
        refreshTable();
    }

    @FXML
    public void handleApproveTransaction() {
        contract.approveTransaction(approveWalletField.getText(), approveTxField.getText());
        refreshTable();
    }

    private void refreshTable() {
        contract.removeExpiredTransactions();
        txList.setAll(contract.getAllPending());
    }
}