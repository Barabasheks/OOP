package com.company;

import java.util.ArrayList;

public interface IDelta extends IPoint{
    void addDeletedFile(IFile file);
    void deleteDeletedFile(IFile file);
    ArrayList<IFile> getAllDeletedFiles();
    String getPath();
}
