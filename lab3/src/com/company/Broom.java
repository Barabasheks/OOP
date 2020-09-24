package com.company;

public class Broom extends AirTransport {
    public Broom(){
        speed = 20;
    }

    @Override
    protected double distantReduce(double distant) {
        return distant / 1000;
    }
}
