package com.company;

public class File implements IFile {
    private String path;
    private int size;

    File(String path, int size){
        this.path = path;
        this.size = size;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public int getSize() {
        return size;
    }
}
