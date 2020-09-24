package com.company;

import java.util.Arrays;

public class AllRace extends Race{
    public AllRace(double distance){
        this.distance = distance;
    }

    public void register(Transport... members){
        this.members.addAll(Arrays.asList(members));
    }
}
