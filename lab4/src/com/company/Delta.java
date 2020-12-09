package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Delta implements IDelta{
    private ArrayList<IFile> deletedFiles = new ArrayList<>();
    private ArrayList<IFile> addedFileList = new ArrayList<>();
    private int id;
    private Date date = new Date();
    private String path;

    public Delta(int id){
        this.id = id;
    }

    public void addDeletedFile(IFile file){
        deletedFiles.add(file);
    }

    public void deleteDeletedFile(IFile file){
        deletedFiles.remove(file);
    }

    public ArrayList<IFile> getAllDeletedFiles(){
        return deletedFiles;
    }

    public void addFile(IFile file){
        addedFileList.add(file);
    }

    public void deleteFile(IFile file){
        addedFileList.remove(file);
    }

    public ArrayList<IFile> getAllFiles(){
        return addedFileList;
    }

    public int size(){
        int size = 0;
        for (var file: addedFileList){
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
        for (var file: getAllFiles())
            stringBuilder.append("      +").append(file.getPath()).append("\n");
        for (var file: getAllDeletedFiles())
            stringBuilder.append("      -").append(file.getPath()).append("\n");
        return stringBuilder.toString();
    }
}
