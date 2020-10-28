package com.company;

public class OneFileSaver implements ISaver {
    private String filePath;

    public OneFileSaver(String filePath){
        this.filePath = filePath;
    }
    @Override
    public void save(IPoint point) {
        //saving in one file
    }
}
