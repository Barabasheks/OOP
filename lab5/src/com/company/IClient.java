package com.company;

import java.util.ArrayList;

public interface IClient {
    int getClientID();
    Account getAccount(int accountID);
    ArrayList<Account> getAllAccounts();
    void setAddress(String address);
    void setPassport(String passport);
    void createAccount(Account account);
}
