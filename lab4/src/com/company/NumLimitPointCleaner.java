package com.company;

public class NumLimitPointCleaner implements IPointCleaner{
    private int pointLimit;
    private boolean warning = false;

    public NumLimitPointCleaner(int pointLimit){
        this.pointLimit = pointLimit;
    }

    @Override
    public int cleaningNum(IBackup backup) {
        var points = backup.getAllPoints();
        int currentPointIndex = backup.numPoints() - pointLimit;
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
