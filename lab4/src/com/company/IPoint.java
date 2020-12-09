package com.company;

import java.util.ArrayList;
import java.util.Date;

public interface IPoint {
    void addFile(IFile file);
    void deleteFile(IFile file);
    ArrayList<IFile> getAllFiles();
    int size();
    int getId();
    Date getDate();
    String getPath();
    void setPath(String path);
}
