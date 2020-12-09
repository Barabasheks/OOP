package com.company;

import java.util.ArrayList;

public class IncPointManager implements IPointManager {
    private IPoint previousFullPoint(ArrayList<IPoint> points){
        IPoint lastFullPoint = null;
        int lastFullPointId = -1;
        for (int i = points.size() - 1; i >= 0; i--){
            if (!(points.get(i) instanceof IDelta)){
                lastFullPoint = points.get(i);
                lastFullPointId = i;
                break;
            }
        }
        if (lastFullPoint == null) throw new RuntimeException("No any full points");
        IPoint previousFullPoint = new FullPoint(-1);
        for (var file: lastFullPoint.getAllFiles()){
            previousFullPoint.addFile(file);
        }
        for (int i = lastFullPointId + 1; i < points.size(); i++){
            IDelta point = (IDelta) points.get(i);
            for (var file: point.getAllFiles()){
                previousFullPoint.addFile(file);
            }
            for (var file: point.getAllDeletedFiles()){
                previousFullPoint.deleteFile(file);
            }
        }
        return previousFullPoint;
    }

    @Override
    public IPoint makePoint(ArrayList<IPoint> points, IPoint currentPoint) {
        IPoint previousFullPoint = previousFullPoint(points);
        IDelta newPoint = new Delta(points.size());
        for (var file: previousFullPoint.getAllFiles()){
            if (!currentPoint.getAllFiles().contains(file)) newPoint.addDeletedFile(file);
        }
        for (var file: currentPoint.getAllFiles()){
            if (!previousFullPoint.getAllFiles().contains(file)) newPoint.addFile(file);
        }
        return newPoint;
    }
}
