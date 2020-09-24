package com.company;

public class CamelSpeedboat extends LandTransport{
    public CamelSpeedboat(){
        speed = 40;
        restInterval = 10;
    }

    @Override
    protected double restDuration(int numRest) {
        if (numRest == 1)
            return 5;
        else if (numRest == 2)
            return 6.5;
        else
            return 8;
    }
}
