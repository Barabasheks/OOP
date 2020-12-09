package com.company;

public class Main {

    public static void main(String[] args) {
        Bank bank1 = (Bank) BankManager.bankManager.createBank(new MoneyRub(1000, 0), new MoneyRub(1000, 0),
                4, (IMoney startingMoney) -> {
            if (startingMoney.getMainPart() < 50000) return 4.5;
            if (startingMoney.getMainPart() < 100000) return 5;
            else return 5.5;
                });

        Bank bank2 = (Bank) BankManager.bankManager.createBank(new MoneyRub(2000, 0), new MoneyRub(2400, 0),
                5, (IMoney startingMoney) -> {
                    if (startingMoney.getMainPart() < 50000) return 5;
                    else return 6;
                });

        var client1 = bank1.createClient(new ClientBuilder("Client1.1", "Client1.2"));
        var client2 = bank2.createClient(new ClientBuilder("Client2.1", "Client2.2").setAddress("address").setPassport("passport"));
        client1.createAccount(new CreditAccount());
        client2.createAccount(new DebitAccount());

        var acc1 = client1.getAccount(0);
        var acc2 = BankManager.bankManager.getAccount("10010");

        System.out.println("Test1");
        bank1.topUpAccount("10000", new MoneyRub(2000, 0));
        try {
            bank1.doTransaction(new SendTransaction(acc1, acc2, new MoneyRub(2000, 0)));
            System.out.println("acc1: " + acc1.getMoney());
            System.out.println("acc2: " + acc2.getMoney());
        } catch (RuntimeException e){
            System.out.println(e);
        }
        client1.setAddress("address2");
        client1.setPassport("address2");
        bank1.sendMoney("10000", "10010", new MoneyRub(2000, 0));
        System.out.println("acc1: " + acc1.getMoney());
        System.out.println("acc2: " + acc2.getMoney());
        System.out.println();

        System.out.println("Test2");
        var trans = bank1.sendMoney("10000", "10010", new MoneyRub(500, 0));
        System.out.println("acc1: " + acc1.getMoney());
        System.out.println("acc2: " + acc2.getMoney());
        bank1.cancelTransaction(trans);
        System.out.println("acc1: " + acc1.getMoney());
        System.out.println("acc2: " + acc2.getMoney());
        System.out.println();

        System.out.println("Test3");
        bank1.withdrawAccount("10000", new MoneyRub(500, 0));
        client1.createAccount(new DepositAccount(90));
        var acc3 = client1.getAccount(1);
        bank1.doTransaction(new TopUpTransaction(acc3, new MoneyRub(2000, 0)));
        System.out.println("acc1: " + acc1.getMoney());
        System.out.println("acc2: " + acc2.getMoney());
        System.out.println("acc3: " + acc3.getMoney());
        var timeManager = new TimeManager(bank1, bank2);
        timeManager.skipDays(31);
        System.out.println("acc1: " + acc1.getMoney());
        System.out.println("acc2: " + acc2.getMoney());
        System.out.println("acc3: " + acc3.getMoney());
    }
}
