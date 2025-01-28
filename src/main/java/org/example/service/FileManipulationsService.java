package org.example.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManipulationsService {
    public static List<String> getFilesNames() {
        ArrayList<String> filesNamesList = new ArrayList<>();
        File folder = new File("src/main/resources/");
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    filesNamesList.add(listOfFile.getName());
                }
            }
        }
        return filesNamesList;
    }
}
