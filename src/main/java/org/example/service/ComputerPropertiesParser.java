package org.example.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class ComputerPropertiesParser {
    public static String parseOsName(String computer) {

        try {
            Document document = Jsoup.parse(new File(computer));
            Elements divHeader = document.select("td:contains(Название ОС)");
            return divHeader.get(0).nextElementSibling().text();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
