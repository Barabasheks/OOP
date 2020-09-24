package com.company;

public class Centaur extends LandTransport{
    public Centaur(){
        speed = 15;
        restInterval = 8;
    }

    @Override
    protected double restDuration(int numRest) {
        return 2;
    }
}
