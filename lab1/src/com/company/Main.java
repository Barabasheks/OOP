package com.company;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        var parser = new IniParser();
        IniData data = new IniData();
        try {
            data = parser.parse(Path.of("C:\\Users\\veden\\Desktop\\OOP\\lab1\\inifiles\\test.ini"));
        } catch (IIOException e) {
            System.out.println("Wrong file name");
        } catch (RuntimeException e) {
            System.out.println(e.toString());
        }

        try {
            System.out.println(data.getInt("DOPINF", "dopInt"));
            System.out.println(data.getInt("COMMON", "Integer"));
            System.out.println(data.getDouble("COMMON", "Double"));
            System.out.println(data.getString("LASTSECTION", "lastString"));
            System.out.println(data.getString("COMMON", "Double"));
            System.out.println(data.getDouble("LASTSECTION", "lastInt"));
            System.out.println(data.getInt("COMMON", "Double")); //cast exception
            System.out.println(data.getInt("COMMON", "wrongNameParam")); //param does not exist
            System.out.println(data.getInt("wrongNameSection", "Integer")); //section does not exist
        } catch (RuntimeException e) {
            System.out.println(e.toString());
        }
    }
}
