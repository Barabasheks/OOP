package com.company;

public abstract class AirTransport extends Transport {
    protected abstract double distantReduce(double distant);

    @Override
    public double timeDistance(double distance) {
        distance -= distance * distantReduce(distance) / 100;
        return distance / speed;
    }
}
