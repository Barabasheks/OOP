package com.company;

import java.util.ArrayList;

public class FullPointManager implements IPointManager {
    @Override
    public IPoint makePoint(ArrayList<IPoint> points, IPoint currentPoint) {
        var newPoint = new FullPoint(points.size());
        for (var file: currentPoint.getAllFiles()){
            newPoint.addFile(file);
        }
        return newPoint;
    }
}
