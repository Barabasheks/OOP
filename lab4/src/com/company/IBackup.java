package com.company;

import java.util.ArrayList;

public interface IBackup {
    void makePoint(IPointManager pointManager, IPointSaver saver);
    ArrayList<IPoint> getAllPoints();
    void addFile(IFile file);
    void deleteFile(IFile file);
    int numPoints();
    int backupSize();
    void deletePoint();
}
