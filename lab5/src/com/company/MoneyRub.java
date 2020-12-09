package com.company;

public class MoneyRub implements IMoney {
    int mainPart;
    int hundredthPart;

    public MoneyRub(int mainPart, int hundredthPart){
        this.mainPart = mainPart;
        this.hundredthPart = hundredthPart;
    }

    public MoneyRub(){
        mainPart = 0;
        hundredthPart = 0;
    }

    @Override
    public int getMainPart() {
        return mainPart;
    }

    @Override
    public int getHundredthPart() {
        return hundredthPart;
    }

    @Override
    public IMoney plus(IMoney money) {
        int hundredthPartSum = this.hundredthPart + money.getHundredthPart();
        int mainPartSum = this.mainPart + money.getMainPart();
        if (hundredthPartSum >= 100) {
            mainPartSum++;
            hundredthPartSum -= 100;
        }
        return new MoneyRub(mainPartSum, hundredthPartSum);
    }

    @Override
    public IMoney minus(IMoney money) {
        int hundredthPartMinus = this.hundredthPart - money.getHundredthPart();
        int mainPartMinus = this.mainPart - money.getMainPart();
        if (hundredthPartMinus < 0) {
            mainPartMinus--;
            hundredthPartMinus += 100;
        }
        return new MoneyRub(mainPartMinus, hundredthPartMinus);
    }

    @Override
    public IMoney multiply(double num) {
        int mainPart = this.getMainPart();
        int hundredthPart = this.getHundredthPart();
        double moneyDouble =  mainPart + hundredthPart / 100.;
        double newMoneyDouble = moneyDouble * num;
        mainPart = (int) newMoneyDouble;
        hundredthPart = (int)((newMoneyDouble - mainPart) * 100);
        return new MoneyRub(mainPart, hundredthPart);
    }

    @Override
    public boolean more(IMoney anotherMoney) {
        double bothPartsThis = this.mainPart + this.hundredthPart / 100.;
        double bothPartsAnotherMoney = anotherMoney.getMainPart() + anotherMoney.getHundredthPart() / 100.;
        return (bothPartsThis > bothPartsAnotherMoney);
    }

    @Override
    public boolean less(IMoney anotherMoney) {
        double bothPartsThis = this.mainPart + this.hundredthPart / 100.;
        double bothPartsAnotherMoney = anotherMoney.getMainPart() + this.hundredthPart / 100.;
        return (bothPartsThis < bothPartsAnotherMoney);
    }

    @Override
    public String toString(){
        return mainPart + "." + hundredthPart;
    }
}
