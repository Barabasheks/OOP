package com.company;

public class Broom extends AirTransport {
    private final double speed = 20;

    @Override
    protected double distantReduce(double distant) {
        return distant / 1000;
    }

    @Override
    public double getSpeed() {
        return speed;
    }
}
