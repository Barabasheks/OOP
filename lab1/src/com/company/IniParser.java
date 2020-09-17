package com.company;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class IniParser {
    public IniData parse(Path path) throws IOException, RuntimeException {
        Scanner in = new Scanner(path);
        IniData data = new IniData();
        String keySection = "";
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isEmpty()) continue;
            if (line.charAt(0) == '[') {
                keySection = line.substring(1, line.length() - 1);
                continue;
            }
            StringBuilder keyLineBuilder = new StringBuilder();
            int i = 0;
            while (line.charAt(i) != '=' && line.charAt(i) != ';') {
                keyLineBuilder.append(line.charAt(i));
                i++;
            }
            String keyLine = keyLineBuilder.toString();
            if (line.charAt(i) == '=') i++;

            StringBuilder valueBuilder = new StringBuilder();
            boolean onlyNums = true;
            int dotNum = 0;
            while (i < line.length() && line.charAt(i) != ';') {
                valueBuilder.append(line.charAt(i));
                if (line.charAt(i) == '.') dotNum++;
                if ((line.charAt(i) > '9' || line.charAt(i) < '0') && line.charAt(i) != '.') onlyNums = false;
                i++;
            }
            String value = valueBuilder.toString();
            if (value.isEmpty()) continue;
            if (onlyNums && dotNum < 2) {
                if (dotNum == 0) {
                    int valueInt = Integer.parseInt(value);
                    data.add(keySection, keyLine, valueInt);
                } else {
                    double valueDouble = Double.parseDouble(value);
                    data.add(keySection, keyLine, valueDouble);
                }
                continue;
            }
            if (keySection.isEmpty() || keyLine.isEmpty())
                throw new RuntimeException("Wrong file format");
            data.add(keySection, keyLine, value);

        }
        return data;
    }
}