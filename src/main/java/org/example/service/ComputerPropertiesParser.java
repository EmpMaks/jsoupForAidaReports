package org.example.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class ComputerPropertiesParser {
    private Document document;

    public ComputerPropertiesParser(String computer) throws IOException {
        document = Jsoup.parse(new File(computer));
    }

    public String parseOsName() {
        Elements divHeader = document.select("td:contains(Название ОС)");
        return divHeader.get(0).nextElementSibling().text();
    }

    public String parseCPU() {
        Elements divHeader = document.select("td:contains(Тип ЦП)");
        return divHeader.get(0).nextElementSibling().text();
    }

    public String parseMotherboard() {
        Elements divHeader = document.select("td:contains(Системная плата)");
        return divHeader.get(1).nextElementSibling().text();
    }
}
