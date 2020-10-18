package com.company;

public class CamelSpeedboat extends LandTransport{
    private final double speed = 40;
    private final double restInterval = 10;

    @Override
    protected double restDuration(int numRest) {
        if (numRest == 1)
            return 5;
        else if (numRest == 2)
            return 6.5;
        else
            return 8;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    protected double getRestInterval() {
        return restInterval;
    }
}
