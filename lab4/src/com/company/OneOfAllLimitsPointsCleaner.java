package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class OneOfAllLimitsPointsCleaner implements IPointCleaner {
    ArrayList<IPointCleaner> cleanerList = new ArrayList<>();
    private boolean warning = false;

    public OneOfAllLimitsPointsCleaner(IPointCleaner... cleaners){
        cleanerList.addAll(Arrays.asList(cleaners));
    }

    @Override
    public int cleaningNum(IBackup backup) {
        int maxDeletedPoints = cleanerList.get(0).cleaningNum(backup);
        for (var cleaner: cleanerList){
            int deletedPoints = cleaner.cleaningNum(backup);
            if (deletedPoints > maxDeletedPoints) {
                maxDeletedPoints = deletedPoints;
                warning = cleaner.getWarning();
            }
            cleaner.reset();
        }
        return maxDeletedPoints;
    }

    @Override
    public boolean getWarning() {
        return warning;
    }

    @Override
    public void reset() {
        warning = false;
    }
}
