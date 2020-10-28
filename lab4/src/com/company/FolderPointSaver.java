package com.company;

public class FolderSaver implements ISaver{
    private String storagePath;

    public FolderSaver(String storagePath){
        this.storagePath = storagePath;
    }

    @Override
    public void save(IPoint point) {
        //saving files
    }
}
