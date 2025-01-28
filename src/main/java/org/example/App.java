package org.example;

import org.example.service.FileManipulationsService;

public class App {
    public static void main(String[] args) {
        FileManipulationsService obj = new FileManipulationsService();
        //obj.getFilesNames();
        for (String str: obj.getFilesNames()) {
            System.out.println(str);
        }
    }
}
