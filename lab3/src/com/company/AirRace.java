package com.company;

import java.util.Arrays;

public class AirRace extends Race{
    public AirRace(double distance){
        this.distance = distance;
    }

    public void register(AirTransport... members){
        this.members.addAll(Arrays.asList(members));
    }
}
