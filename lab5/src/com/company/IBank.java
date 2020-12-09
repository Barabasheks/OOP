package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public interface IBank {
    ArrayList<IClient> getAllClients();
    IClient getClient(int userID);
    IClient createClient(ClientBuilder builder);
    IMoney getCreditCommissionDay();
    double getDepositPercentDay(IMoney startingMoney);
    double getDebitPercentDay();
    IMoney getNotFullClientLimit();
    void calcDay();
    void cancelTransaction(ITransaction transaction);
    ArrayList<ITransaction> getAllTransactions();
    String getBankID();
    ArrayList<Account> getAllAccounts();
    ITransaction doTransaction(ITransaction transaction);
}
