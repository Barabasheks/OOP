package com.company;

public class OneFilePointSaver implements IPointSaver {
    private String filePath;

    public OneFilePointSaver(String filePath){
        this.filePath = filePath;
    }
    @Override
    public void save(IPoint point) {
        //saving in one file
        point.setPath(filePath + point.getId());
    }
}
