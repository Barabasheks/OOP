package com.company;

import java.util.Date;

public class DateLimitPointCleaner implements IPointCleaner{
    private Date dateLimit;
    private boolean warning = false;

    public DateLimitPointCleaner(Date dateLimit){
        this.dateLimit = dateLimit;
    }

    @Override
    public int cleaningNum(IBackup backup) {
        var points = backup.getAllPoints();
        int i = 0;
        var currentPoint = points.get(0);
        while (currentPoint.getDate().getTime() < dateLimit.getTime()){
            i++;
            currentPoint = points.get(i);
        }
        int currentPointIndex = i;
        var point = points.get(currentPointIndex);
        while (point instanceof  IDelta){
            warning = true;
            currentPointIndex--;
            point = points.get(currentPointIndex);
        }
        return currentPointIndex;
    }

    @Override
    public boolean getWarning() {
        return warning;
    }

    public void reset(){
        warning = false;
    }
}
