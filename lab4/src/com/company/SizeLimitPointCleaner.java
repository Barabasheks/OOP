package com.company;

import java.util.ArrayList;
import java.util.logging.Logger;

public class SizeLimitPointCleaner implements IPointCleaner{
    private int sizeLimit;
    private boolean warning = false;

    public SizeLimitPointCleaner(int sizeLimit){
        this.sizeLimit = sizeLimit;
    }

    @Override
    public int cleaningNum(IBackup backup) {
        var points = backup.getAllPoints();
        IPoint currentPoint = null;
        int deletedPointsSize = 0;
        int i = 0;
        while (backup.backupSize() - deletedPointsSize > sizeLimit){
            currentPoint = points.get(i);
            deletedPointsSize += currentPoint.size();
            i++;
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
