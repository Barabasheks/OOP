package com.company;

public class BactrianCamel extends LandTransport {
    public BactrianCamel(){
        speed = 10;
        restInterval = 30;
    }

    protected double restDuration(int numRest) {
        if (numRest == 1)
            return 5;
        else
            return 8;
    }
}
