package com.company;

import java.util.Arrays;

public class LandRace extends Race{
    public LandRace(double distance){
        this.distance = distance;
    }

    public void register(LandTransport... members){
        this.members.addAll(Arrays.asList(members));
    }
}
