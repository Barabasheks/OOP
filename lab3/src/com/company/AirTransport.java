package com.company;

public abstract class AirTransport implements Transport {
    protected abstract double distantReduce(double distant);
    public abstract double getSpeed();

    @Override
    public double timeDistance(double distance) {
        distance -= distance * distantReduce(distance) / 100;
        return distance / getSpeed();
    }
}
