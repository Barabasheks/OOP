package com.company;

import java.util.HashMap;

public class IniData {
    private HashMap<String, IniSection> mapFile;

    public IniData(){
        mapFile = new HashMap<>();
    }

    public void add(String keySection, String keyLine, Object value){
        IniSection section;
        if (mapFile.containsKey(keySection)){
            section = mapFile.get(keySection);
        }else {
            section = new IniSection();
            mapFile.put(keySection, section);
        }
        section.addLine(keyLine, value);
    }

    private IniSection tryGetSection(String keySection) throws RuntimeException{
        IniSection section = mapFile.get(keySection);
        if (section == null) throw new RuntimeException("Section does not exist");
        return section;
    }

    public int getInt(String keySection, String keyLine) throws RuntimeException{
        IniSection section = tryGetSection(keySection);
        var line = section.getLine(keyLine);
        if (!(line instanceof Integer))
            throw new ClassCastException("Wrong type");
        return (int)line;
    }

    public double getDouble(String keySection, String keyLine) throws RuntimeException{
        IniSection section = tryGetSection(keySection);
        var line = section.getLine(keyLine);
        double rez;
        if (line instanceof Integer) {
            rez = (int) line;
        }
        else if (line instanceof Double)
                rez = (double) line;
        else throw new ClassCastException("Wrong type");
        return rez;
    }

    public String getString(String keySection, String keyLine) throws RuntimeException{
        IniSection section = tryGetSection(keySection);
        var line = section.getLine(keyLine);
        String rez;
        if (line instanceof Integer) {
            int intRez = (int) line;
            rez = Integer.toString(intRez);
        }
        else if (line instanceof Double) {
            double doubleRez = (double) line;
            rez = Double.toString(doubleRez);
        }
        else rez = (String) line;
        return rez;
    }
}
