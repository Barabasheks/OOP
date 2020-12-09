package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class AllLimitsPointCleaner implements IPointCleaner{
    ArrayList<IPointCleaner> cleanerList = new ArrayList<>();
    private boolean warning = false;

    public AllLimitsPointCleaner(IPointCleaner... cleaners){
        cleanerList.addAll(Arrays.asList(cleaners));
    }

    @Override
    public int cleaningNum(IBackup backup) {
        int minDeletedPoints = cleanerList.get(0).cleaningNum(backup);
        for (var cleaner: cleanerList){
            int deletedPoints = cleaner.cleaningNum(backup);
            if (deletedPoints < minDeletedPoints) {
                minDeletedPoints = deletedPoints;
                warning = cleaner.getWarning();
            }
            cleaner.reset();
        }
        return minDeletedPoints;
    }

    @Override
    public boolean getWarning() {
        return false;
    }

    @Override
    public void reset() {

    }
}
