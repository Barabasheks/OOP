package com.company;

public class TopUpTransaction implements ITransaction {
    private Account account;
    private IMoney money;
    private int transactionID;

    public TopUpTransaction(Account account, IMoney money, int transactionID) {
        this.account = account;
        this.money = money;
        this.transactionID = transactionID;
    }

    public TopUpTransaction(Account account, IMoney money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public int getTransactionID() {
        return transactionID;
    }

    @Override
    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    @Override
    public void doTransaction() {
        account.plusMoney(money);
    }

    @Override
    public void cancelTransaction() {
        account.minusMoney(money);
    }
}
