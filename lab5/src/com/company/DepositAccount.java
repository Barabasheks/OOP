package com.company;

public class DepositAccount extends Account {
    private IMoney startingMoney;
    private IMoney monthMoney;
    private int days;
    private int daysToMinus;

    private DepositAccount(int accountID, IBank bank, IClient client, int daysToMinus){
        super(accountID, bank, client);
        startingMoney = null;
        monthMoney = new MoneyRub();
        this.daysToMinus = daysToMinus;
    }

    public DepositAccount(int daysToMinus){
        this.daysToMinus = daysToMinus;
    }

    @Override
    public Account create(int accountID, IBank bank, IClient client) {
        return new DepositAccount(accountID, bank, client, daysToMinus);
    }

    @Override
    public void plusMoney(IMoney anotherMoney) {
        super.plusMoney(anotherMoney);
        if (startingMoney == null) startingMoney = anotherMoney;
    }

    @Override
    public void minusMoney(IMoney anotherMoney) throws RuntimeException{
        if (daysToMinus > 0) throw new RuntimeException("It is too early to minus money from deposit!");
        if (money.minus(anotherMoney).getMainPart() < 0) throw new RuntimeException("DepositAccount can not go to minus");
        super.minusMoney(anotherMoney);
    }

    @Override
    public void calcDay() {
        if (days < 30) {
            double percent = getBank().getDepositPercentDay(startingMoney);
            monthMoney = monthMoney.plus(getMoney().multiply(percent / 100));
            days++;
        }
        else {
            money = getMoney().plus(monthMoney);
            days = 0;
            monthMoney = new MoneyRub();
        }
        daysToMinus--;
    }

    @Override
    public IMoney getMoney(){
        return money;
    }
}
