package com.company;

public class MagicCarpet extends AirTransport {
    public MagicCarpet(){
        speed = 10;
    }

    @Override
    protected double distantReduce(double distant) {
        if (distant < 1000)
            return 0;
        else if (distant < 5000)
            return 3;
        else if (distant < 10000)
            return 10;
        else
            return 5;
    }
}
