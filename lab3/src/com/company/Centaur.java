package com.company;

public class Centaur extends LandTransport{
    private final double speed = 15;
    private final double restInterval = 8;

    @Override
    protected double getRestInterval() {
        return restInterval;
    }

    @Override
    protected double restDuration(int numRest) {
        return 2;
    }

    @Override
    public double getSpeed() {
        return speed;
    }
}
