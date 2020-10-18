package com.company;

import java.util.ArrayList;

interface Race {
    ArrayList<Transport> getMembers();
    void setMembers(ArrayList<Transport> members);
    double getDistance();
    void setDistance(double distance);

    default public Transport start(){
        Transport winner = null;
        double minTime = 0;
        boolean winnerIsNull = true;
        for (var member: getMembers()){
            if (winnerIsNull || minTime > member.timeDistance(getDistance())){
                winner = member;
                winnerIsNull = false;
                minTime = member.timeDistance(getDistance());
            }
        }
        return winner;
    }
}
