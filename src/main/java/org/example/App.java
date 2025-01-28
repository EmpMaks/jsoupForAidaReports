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
            stringForCsv.append(ComputerPropertiesParser.parseOsName(computer)).append(";\n");
        }
        try {
            Files.write(Paths.get("C:\\Users\\Maks\\Desktop\\jsoup\\jsoup\\jsoup\\src\\main\\output\\output.csv"),
                    stringForCsv.toString().getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
