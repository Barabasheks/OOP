package com.company;

public class SendTransaction implements ITransaction {
    private IMoney sendingMoney;
    private Account from, to;
    private int transactionID;

    public SendTransaction(Account from, Account to, IMoney sendingMoney, int transactionID){
        this.from = from;
        this.to = to;
        this.sendingMoney = sendingMoney;
        this.transactionID = transactionID;
    }

    public SendTransaction(Account from, Account to, IMoney sendingMoney){
        this.from = from;
        this.to = to;
        this.sendingMoney = sendingMoney;
    }

    public int getTransactionID() {
        return transactionID;
    }

    @Override
    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    @Override
    public void doTransaction() {
        from.minusMoney(sendingMoney);
        to.plusMoney(sendingMoney);
    }

    @Override
    public void cancelTransaction() {
        from.plusMoney(sendingMoney);
        to.minusMoney(sendingMoney);
    }
}
