package com.company;

public abstract class LandTransport implements Transport {
    protected abstract double getRestInterval();
    protected abstract double restDuration(int numRest);
    public abstract double getSpeed();

    @Override
    public double timeDistance(double distance) {
        double timeDistance = 0;
        double curDistance = 0;
        int numRest = 0;
        while ((distance - curDistance) / getSpeed() > getRestInterval()){
            curDistance += getSpeed() * getRestInterval();
            timeDistance += getRestInterval();
            numRest++;
            timeDistance += restDuration(numRest);
        }
        timeDistance += (distance - curDistance) / getSpeed();
        return timeDistance;
    }
}
