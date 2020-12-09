package com.company;

public class FolderPointSaver implements IPointSaver {
    private String storagePath;

    public FolderPointSaver(String storagePath){
        this.storagePath = storagePath;
    }

    @Override
    public void save(IPoint point) {
        //saving files
        point.setPath(storagePath + point.getId());
    }
}
