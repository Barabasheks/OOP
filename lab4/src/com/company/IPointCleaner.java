package com.company;

import java.util.logging.Logger;

public interface IPointCleaner {
    default void clean(IBackup backup){
        int num = cleaningNum(backup);
        if (getWarning()) {
            Logger.getLogger(Main.class.getName()).warning("Deleted less points than was planning");
            reset();
        }
        for (int i = 0; i < num; i++) backup.deletePoint();
    }

    int cleaningNum(IBackup backup);
    boolean getWarning();
    void reset();
}
