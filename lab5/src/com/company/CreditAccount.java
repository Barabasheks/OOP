package com.company;

public class CreditAccount extends Account {
    private IMoney monthMoney;
    private int days;

    private CreditAccount(int accountID, IBank bank, IClient client){
        super(accountID, bank, client);
        monthMoney = new MoneyRub();
        days = 0;
    }

    public CreditAccount(){}

    @Override
    public Account create(int accountID, IBank bank, IClient client) {
        return new CreditAccount(accountID, bank, client);
    }

    @Override
    public void calcDay() {
        if (days < 30){
            if (money.getMainPart() < 0) monthMoney = monthMoney.plus(getBank().getCreditCommissionDay());
            days++;
        }
        else {
            money = getMoney().minus(monthMoney);
            days = 0;
            monthMoney = new MoneyRub();
        }
    }

    @Override
    public IMoney getMoney(){
        return money;
    }
}
