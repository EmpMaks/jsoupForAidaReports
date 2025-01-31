package org.example;

import org.example.service.ComputerPropertiesParser;
import org.example.service.FileManipulationsService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class App {
    private static ArrayList<String> computersList = (ArrayList<String>) FileManipulationsService.getFilesNames();

    public static void main(String[] args) {
        StringBuilder stringForCsv = new StringBuilder();
        for (String fileName : computersList) {
            String computer = "src/main/resources/" + fileName;
            ComputerPropertiesParser computerPropertiesParser = null;
            try {
                computerPropertiesParser = new ComputerPropertiesParser(computer);
                stringForCsv.append(computerPropertiesParser.parseOsName()).append(";");
                stringForCsv.append(computerPropertiesParser.parseCPU()).append(";");
                stringForCsv.append(computerPropertiesParser.parseMotherboard()).append(";");
                stringForCsv.append(computerPropertiesParser.parseRAMSlotsAmount()).append(";");
                stringForCsv.append(computerPropertiesParser.parseRAMVolume()).append(";");
                stringForCsv.append(computerPropertiesParser.parseGPU()).append(";\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Files.write(Paths.get("C:\\Users\\Maks\\IdeaProjects\\GITjsoup\\src\\main\\output\\output.csv"),
                    stringForCsv.toString().getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
