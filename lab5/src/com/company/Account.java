package com.company;

public abstract class Account {
    private int accountID;
    private  IBank bank;
    private  IClient client;
    private String fullAccountID;
    protected IMoney money;
    private AccountState state = null;


    Account(int accountID, IBank bank, IClient client) {
        this.accountID = accountID;
        this.bank = bank;
        this.client = client;
        this.fullAccountID = bank.getBankID() + accountID;
        money = new MoneyRub();
    }

    Account() {}

    public abstract Account create(int accountID, IBank bank, IClient client);

    int getAccountID() {
        return accountID;
    }

    public void plusMoney(IMoney anotherMoney){
        money = money.plus(anotherMoney);
    }

    public void minusMoney(IMoney anotherMoney){
        state.minusMoney(anotherMoney);
    }

    public IBank getBank() {
        return bank;
    }

    public IClient getClient() {
        return client;
    }

    public abstract void calcDay();
    public abstract IMoney getMoney();

    public String getFullAccountID() {
        return fullAccountID;
    }

    public void changeState(AccountState state){
        this.state = state;
    }
}
