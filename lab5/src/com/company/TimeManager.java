package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class TimeManager {
    ArrayList<IBank> banks;
    public TimeManager(IBank... banks){
        this.banks = new ArrayList<IBank>(Arrays.asList(banks));
    }

    public void skipDays(int days){
        for (int i = 0; i < days; i++){
            for (var bank: banks) bank.calcDay();
        }
    }
}
