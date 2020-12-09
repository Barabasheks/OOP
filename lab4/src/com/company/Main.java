package com.company;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        File file1 = new File("C:\\Users\\File1", 100);
        File file2 = new File("C:\\Users\\File2", 100);
        File file3 = new File("C:\\Users\\File3", 50);
        File file4 = new File("C:\\Users\\File4", 25);

        System.out.println("_________UseCase1_________: ");
        var folderSaver = new FolderPointSaver("C:\\Users\\Folder1");
        var fullPointManager = new FullPointManager();
        var backup1 = new Backup(file1);
        backup1.addFile(file2);
        backup1.makePoint(fullPointManager, folderSaver);
        System.out.println(backup1);
        backup1.addFile(file3);
        backup1.deleteFile(file2);
        backup1.makePoint(fullPointManager, folderSaver);
        System.out.println(backup1);
        var num1Cleaner = new NumLimitPointCleaner(1);
        num1Cleaner.clean(backup1);
        System.out.println(backup1);

        System.out.println("_________UseCase2_________: ");
        var backup2 = new Backup(file1);
        backup2.makePoint(fullPointManager, folderSaver);
        System.out.println(backup2);
        backup2.makePoint(fullPointManager, folderSaver);
        System.out.println(backup2);
        System.out.println("Size: " + backup2.backupSize());
        var size1Cleaner = new SizeLimitPointCleaner(150);
        size1Cleaner.clean(backup2);
        System.out.println(backup2);

        System.out.println("_________UseCase3_________: ");
        var fileSaver = new OneFilePointSaver("C:\\Users\\Folder1");
        var incPointManager = new IncPointManager();
        var backup3 = new Backup(file1);
        backup3.addFile(file2);
        backup3.deleteFile(file1);
        backup3.makePoint(incPointManager, fileSaver);
        System.out.println(backup3);
        backup3.addFile(file3);
        backup3.addFile(file4);
        backup3.makePoint(incPointManager, fileSaver);
        System.out.println(backup3);
        backup3.deleteFile(file2);
        backup3.deleteFile(file4);
        backup3.addFile(file1);
        backup3.makePoint(fullPointManager, fileSaver);
        System.out.println(backup3);
        backup3.addFile(file2);
        backup3.deleteFile(file1);
        backup3.makePoint(incPointManager, fileSaver);
        backup3.getAllPoints().get(0).addFile(file4);
        System.out.println(backup3);
        backup3.makePoint(fullPointManager, fileSaver);
        System.out.println(backup3);
        backup3.addFile(file1);
        backup3.makePoint(incPointManager, fileSaver);
        backup3.deleteFile(file3);
        backup3.makePoint(fullPointManager, fileSaver);
        SizeLimitPointCleaner sizeCleaner = new SizeLimitPointCleaner(300);
        System.out.println(backup3);
        sizeCleaner.clean(backup3);
        System.out.println(backup3);

        System.out.println("_________UseCase4_________: ");
        Backup backup4 = new Backup();
        backup4.addAllFiles(file1, file2, file3);
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        Date date1 = new Date();
        backup4.makePoint(incPointManager, fileSaver);
        backup4.deleteFile(file3);
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        Date date2 = new Date();
        backup4.makePoint(incPointManager, fileSaver);
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        Date date3 = new Date();
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        backup4.makePoint(fullPointManager, fileSaver);
        try{
        Thread.sleep(100);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        Date date4 = new Date();
        backup4.addAllFiles(file4);
        backup4.makePoint(incPointManager, fileSaver);
        backup4.makePoint(fullPointManager, fileSaver);
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        Date date5 = new Date();
        System.out.println(backup4);
        var dateCleaner = new DateLimitPointCleaner(date3);
        var oneOfAllCleaner = new OneOfAllLimitsPointsCleaner(dateCleaner, num1Cleaner);
        oneOfAllCleaner.clean(backup4);
        System.out.println(backup4);
    }
}
