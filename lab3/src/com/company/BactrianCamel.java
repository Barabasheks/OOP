package com.company;

public class BactrianCamel extends LandTransport {
    private final double speed = 10;
    private final double restInterval = 30;

    @Override
    protected double getRestInterval() {
        return restInterval;
    }

    protected double restDuration(int numRest) {
        if (numRest == 1)
            return 5;
        else
            return 8;
    }

    @Override
    public double getSpeed() {
        return speed;
    }
}
