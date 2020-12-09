package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Backup implements IBackup{
    private ArrayList<IPoint> pointList = new ArrayList<>();
    private IPoint currentPoint = new FullPoint(-1);

    public Backup(){}
    public Backup(@NotNull IFile... files){
        for (var file : files){
            currentPoint.addFile(file);
        }
    }

    @Override
    public void makePoint(IPointManager pointManager, IPointSaver saver){
        if (pointList.isEmpty()){
            var newPoint = new FullPoint(0);
            for (var file: currentPoint.getAllFiles()){
                newPoint.addFile(file);
            }
            pointList.add(newPoint);
        }
        else pointList.add(pointManager.makePoint(pointList, currentPoint));
        saver.save(pointList.get(pointList.size() - 1));
    }

    @Override
    public ArrayList<IPoint> getAllPoints() {
        return pointList;
    }

    @Override
    public void addFile(IFile file) {
        currentPoint.addFile(file);
    }

    public void addAllFiles(IFile... files){
        for (var file: files){
            addFile(file);
        }
    }

    @Override
    public void deleteFile(IFile file) {
        currentPoint.deleteFile(file);
    }

    public void deleteAllFiles(IFile... files){
        for (var file: files){
            deleteFile(file);
        }
    }

    public int numPoints(){
        return pointList.size();
    }

    public int backupSize(){
        int sumSize = 0;
        for (var point: pointList){
            sumSize += point.size();
        }
        return sumSize;
    }

    @Override
    public void deletePoint() {
        pointList.remove(0);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Backup:\n");
        for (var point: getAllPoints()){
            stringBuilder.append(point.toString());
        }
        return stringBuilder.toString();
    }
}
