package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Client implements IClient {
    private HashMap<Integer, Account> accounts = new HashMap<>();
    private int clientID;
    private String firstName, secondName, address = null, passport = null;
    private final IBank bank;

    public Client(int clientID, ClientBuilder builder, IBank bank) {
        this.clientID = clientID;
        this.firstName = builder.getFirstName();
        this.secondName = builder.getSecondName();
        this.address = builder.getAddress();
        this.passport = builder.getPassport();
        this.bank = bank;
    }

    @Override
    public int getClientID() {
        return clientID;
    }

    @Override
    public Account getAccount(int accountID) {
        return accounts.get(accountID);
    }

    @Override
    public ArrayList<Account> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
        if (isClientFull()){
            for (var acc: getAllAccounts()){
                acc.changeState(new AccountStateNotDoubtful(acc));
            }
        }else {
            for (var acc: getAllAccounts()){
                acc.changeState(new AccountStateDoubtful(acc));
            }
        }
    }

    @Override
    public void setPassport(String passport) {
        this.passport = passport;
        if (isClientFull()){
            for (var acc: getAllAccounts()){
                acc.changeState(new AccountStateNotDoubtful(acc));
            }
        }else {
            for (var acc: getAllAccounts()){
                acc.changeState(new AccountStateDoubtful(acc));
            }
        }
    }

    public boolean isClientFull() {
        return (address != null) && (passport != null);
    }

    @Override
    public void createAccount(Account account) {
        int accountID = bank.getAllAccounts().size();
        var newAccount = account.create(accountID, bank, this);
        if (isClientFull()) newAccount.changeState(new AccountStateNotDoubtful(newAccount));
        else newAccount.changeState(new AccountStateDoubtful(newAccount));
        accounts.put(newAccount.getAccountID(), newAccount);
    }
}