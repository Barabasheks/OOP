package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank implements IBank {
    private HashMap<Integer, IClient> allClients = new HashMap<>();
    private IMoney creditCommission;
    private double debitPercent;
    private IMoney notFullUserLimit;
    private IDepositPercent depositPercent;
    private ArrayList<ITransaction> transactions = new ArrayList<>();
    private String bankID;

    public Bank(IMoney notFullUserLimit, IMoney creditCommission, double debitPercent, IDepositPercent depositPercent, String bankID){
        this.notFullUserLimit = notFullUserLimit;
        this.creditCommission = creditCommission;
        if (debitPercent < 0) debitPercent *= -1;
        this.debitPercent = debitPercent;
        this.depositPercent = depositPercent;
        this.bankID = bankID;
    }

    @Override
    public ArrayList<IClient> getAllClients() {
        return new ArrayList<>(allClients.values());
    }

    @Override
    public IClient getClient(int clientID) {
        return allClients.get(clientID);
    }

    @Override
    public IClient createClient(ClientBuilder builder) {
        var newClient = new Client(allClients.size(), builder, this);
        allClients.put(newClient.getClientID(), newClient);
        return newClient;
    }

    @Override
    public IMoney getCreditCommissionDay() {
        return creditCommission.multiply(1./365.);
    }

    @Override
    public double getDepositPercentDay(IMoney startingMoney) {
        return depositPercent.getDepositPercent(startingMoney) / 365.;
    }

    @Override
    public double getDebitPercentDay() {
        return debitPercent / 365.;
    }

    @Override
    public IMoney getNotFullClientLimit() {
        return notFullUserLimit;
    }

    @Override
    public void calcDay() {
        var clients = allClients.values();
        for (var client: clients){
            var accounts = client.getAllAccounts();
            for (var account: accounts) account.calcDay();
        }
    }

    @Override
    public void cancelTransaction(ITransaction transaction) throws RuntimeException{
        for (var trans: transactions){
            if (trans.getTransactionID() == transaction.getTransactionID()){
                transaction.cancelTransaction();
                transactions.remove(transaction);
                return;
            }
        }
        throw new RuntimeException("This transaction does not exist!");
    }

    @Override
    public ArrayList<ITransaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }

    @Override
    public String getBankID() {
        return bankID;
    }

    @Override
    public ArrayList<Account> getAllAccounts() {
        var allAccounts = new ArrayList<Account>();
        for (var client: allClients.values()){
            allAccounts.addAll(client.getAllAccounts());
        }
        return allAccounts;
    }

    @Override
    public ITransaction doTransaction(ITransaction transaction) {
        transaction.setTransactionID(transactions.size());
        transaction.doTransaction();
        transactions.add(transaction);
        return transaction;
    }

    public ITransaction sendMoney(String fromFullAccountID, String toFullAccountID, IMoney sendingMoney) {
        String fromBankID = fromFullAccountID.substring(0, 4);
        if (this != BankManager.bankManager.getBank(fromBankID)) throw new RuntimeException("This bank can not do this operation!");
        var fromAccount = BankManager.bankManager.getAccount(fromFullAccountID);
        var toAccount = BankManager.bankManager.getAccount(toFullAccountID);
        var transaction = new SendTransaction(fromAccount, toAccount, sendingMoney);
        doTransaction(transaction);
        return transaction;
    }

    public ITransaction topUpAccount(String FullAccountID, IMoney money) {
        String BankID = FullAccountID.substring(0, 4);
        if (this != BankManager.bankManager.getBank(BankID)) throw new RuntimeException("This bank can not do this operation!");
        var account = BankManager.bankManager.getAccount(FullAccountID);
        var transaction = new TopUpTransaction(account, money);
        doTransaction(transaction);
        return transaction;
    }

    public ITransaction withdrawAccount(String FullAccountID, IMoney money) {
        String BankID = FullAccountID.substring(0, 4);
        if (this != BankManager.bankManager.getBank(BankID)) throw new RuntimeException("This bank can not do this operation!");
        var account = BankManager.bankManager.getAccount(FullAccountID);
        var transaction = new WithdrawTransaction(account, money);
        doTransaction(transaction);
        return transaction;
    }
}
