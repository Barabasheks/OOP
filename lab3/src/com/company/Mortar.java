package com.company;

public class Mortar extends AirTransport {
    private final double speed = 8;

    @Override
    protected double distantReduce(double distant) {
        return 6;
    }

    @Override
    public double getSpeed() {
        return speed;
    }
}
