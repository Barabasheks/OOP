package com.company;

public class Mortar extends AirTransport {
    public Mortar(){
        speed = 8;
    }

    @Override
    protected double distantReduce(double distant) {
        return 6;
    }
}
