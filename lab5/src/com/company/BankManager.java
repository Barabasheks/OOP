package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class BankManager {
    public static BankManager bankManager = new BankManager();
    private HashMap<String, IBank> allBanks = new HashMap<>();

    public ArrayList<IBank> getAllBanks() {
        return new ArrayList<>(allBanks.values());
    }

    public IBank createBank(IMoney notFullUserLimit, IMoney creditCommission, double debitPercent, IDepositPercent depositPercent){
        if (allBanks.size() > 8999) throw new RuntimeException("Do not can create more banks!");
        var newBank = new Bank(notFullUserLimit, creditCommission, debitPercent, depositPercent, Integer.toString(allBanks.size() + 1000));
        allBanks.put(Integer.toString(allBanks.size() + 1000), newBank);
        return newBank;
    }

    public IBank getBank(String bankID){
        return allBanks.get(bankID);
    }

    public Account getAccount(String fullAccountID){
        String bankID = fullAccountID.substring(0, 4);
        int accountID = Integer.parseInt(fullAccountID.substring(4));
        var bank = bankManager.getBank(bankID);
        if (bank == null) throw new RuntimeException("Bank does not exist!");
        return bank.getAllAccounts().get(accountID);
    }
}
