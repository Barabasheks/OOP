package com.company;

public interface ITransaction {
    int getTransactionID();
    void doTransaction();
    void cancelTransaction();
    void setTransactionID(int transactionID);
}
