package com.company;

import java.util.ArrayList;
import java.util.Date;

public class FullPoint implements IPoint {
    private ArrayList<IFile> fileList = new ArrayList<>();
    private int id;
    private Date date = new Date();
    private String path;

    public FullPoint(int id){
        this.id = id;
    }

    public void addFile(IFile file){
        fileList.add(file);
    }

    public void deleteFile(IFile file){
        fileList.remove(file);
    }

    public ArrayList<IFile> getAllFiles(){
        return fileList;
    }

    public int size(){
        int size = 0;
        for (var file: fileList){
            size += file.getSize();
        }
        return size;
    }

    public int getId(){
        return id;
    }

    public Date getDate(){
        return date;
    }

    @Override
    public String getPath() {
        return path;
    }

    public void setPath(String path){
        this.path = path;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  ---id: ").append(getId()).append("\n");
        for (var file: getAllFiles()){
            stringBuilder.append("      #").append(file.getPath()).append("\n");
        }
        return stringBuilder.toString();
    }
}
