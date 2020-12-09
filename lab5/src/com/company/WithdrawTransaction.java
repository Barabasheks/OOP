package com.company;

public class WithdrawTransaction implements ITransaction {
    private Account account;
    private IMoney money;
    private int transactionID;

    public WithdrawTransaction(Account account, IMoney money, int transactionID) {
        this.account = account;
        this.money = money;
        this.transactionID = transactionID;
    }

    public WithdrawTransaction(Account account, IMoney money) {
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
        account.minusMoney(money);
    }

    @Override
    public void cancelTransaction() {
        account.plusMoney(money);
    }
}
