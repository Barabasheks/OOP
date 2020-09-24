package com.company;

public abstract class LandTransport extends Transport {
    protected double restInterval;
    protected abstract double restDuration(int numRest);

    @Override
    public double timeDistance(double distance) {
        double timeDistance = 0;
        double curDistance = 0;
        int numRest = 0;
        while ((distance - curDistance) / speed > restInterval){
            curDistance += speed * restInterval;
            timeDistance += restInterval;
            numRest++;
            timeDistance += restDuration(numRest);
        }
        timeDistance += (distance - curDistance) / speed;
        return timeDistance;
    }
}
