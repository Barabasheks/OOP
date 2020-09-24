package com.company;

public class BootsAllTerrain extends LandTransport {
    public BootsAllTerrain(){
        speed = 6;
        restInterval = 60;
    }

    @Override
    protected double restDuration(int numRest) {
        if (numRest == 1)
            return 10;
        else
            return 5;
    }
}
