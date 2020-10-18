package com.company;

public class BootsAllTerrain extends LandTransport {
    private final double speed = 6;
    private final double restInterval = 60;

    @Override
    protected double getRestInterval() {
        return restInterval;
    }

    @Override
    protected double restDuration(int numRest) {
        if (numRest == 1)
            return 10;
        else
            return 5;
    }

    @Override
    public double getSpeed() {
        return speed;
    }
}
