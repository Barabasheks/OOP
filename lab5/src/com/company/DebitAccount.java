package com.company;

public class DebitAccount extends Account {
    private IMoney monthMoney;
    private int days;

    private DebitAccount(int accountID, IBank bank, IClient client){
        super(accountID, bank, client);
        monthMoney = new MoneyRub();
        days = 0;
    }

    public DebitAccount(){}

    @Override
    public Account create(int accountID, IBank bank, IClient client) {
        return new DebitAccount(accountID, bank, client);
    }

    @Override
    public void minusMoney(IMoney anotherMoney) throws RuntimeException{
        if (money.minus(anotherMoney).getMainPart() < 0) throw new RuntimeException("DebitAccount can not go to minus balance");
        super.minusMoney(anotherMoney);
    }

    @Override
    public void calcDay() {
        if (days < 30) {
            monthMoney = monthMoney.plus(getMoney().multiply(getBank().getDebitPercentDay() / 100));
            days++;
        }
        else {
            money = getMoney().plus(monthMoney);
            days = 0;
            monthMoney = new MoneyRub();
        }
    }

    @Override
    public IMoney getMoney(){
        return money;
    }
}
