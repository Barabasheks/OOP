package com.company;

import java.util.HashMap;

public class IniSection {
    private HashMap<String, Object> mapSection;

    public IniSection(){
        mapSection = new HashMap<>();
    }

    public Object getLine(String key){
        Object value =  mapSection.get(key);
        if (value == null) throw new RuntimeException("Parameter does not exist");
        return value;
    }

    public void addLine(String key, Object value){
        mapSection.put(key, value);
    }
}
