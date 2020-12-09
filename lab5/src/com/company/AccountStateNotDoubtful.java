package com.company;

public class AccountStateNotDoubtful implements AccountState {
    private Account account;

    AccountStateNotDoubtful(Account account){
        this.account = account;
    }

    @Override
    public void minusMoney(IMoney anotherMoney) {
        account.money = account.money.minus(anotherMoney);
    }
}
