package com.company;

import java.util.ArrayList;

public abstract class Race {
    protected ArrayList<Transport> members = new ArrayList<>();
    protected double distance;

    public Transport start(){
        Transport winner = null;
        double minTime = 0;
        boolean winnerIsNull = true;
        for (var member: members){
            if (winnerIsNull || minTime > member.timeDistance(distance)){
                winner = member;
                winnerIsNull = false;
                minTime = member.timeDistance(distance);
            }
        }
        return winner;
    }
}
