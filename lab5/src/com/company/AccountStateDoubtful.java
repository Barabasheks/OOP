package com.company;

public class AccountStateDoubtful implements AccountState{
    private Account account;

    AccountStateDoubtful(Account account){
        this.account = account;
    }

    @Override
    public void minusMoney(IMoney anotherMoney) {
        if (anotherMoney.more(account.getBank().getNotFullClientLimit())) throw  new RuntimeException("Account is doubtful!");
        account.money = account.money.minus(anotherMoney);
    }
}
