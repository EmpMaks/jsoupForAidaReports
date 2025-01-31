package org.example.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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

    public String parseRAMSlotsAmount() {
        Elements divHeader = document.select("td:contains(Разъёмы ОЗУ)");
        return divHeader.size() != 0 ? divHeader.get(0).nextElementSibling().text() : "";
    }

    public String parseRAMVolume() {
        Elements divHeader = document.select("td:contains(Системная память)");
        return divHeader.size() != 0 ? divHeader.get(0).nextElementSibling().text() : "";
    }

//    public String parseRAMSticks() {
//        return Integer.toString(document.select("td:contains(Имя модуля)").size());
//    }

    public String parseGPU() {
        Elements divHeader = document.select("td:contains(Дисплей:)");
        Element element = divHeader.parents().get(0).nextElementSibling();
        Elements adapter = element.select("td:contains(Видеоадаптер)");
        return adapter.get(0).nextElementSibling().text();
    }

    public String parseMonitor() {
        Elements divHeader = document.select("td:contains(Дисплей:)");
        Element element = divHeader.parents().get(0).nextElementSibling().nextElementSibling().nextElementSibling();
        Elements adapter = element.select("td:contains(Монитор)");
        return adapter.size() != 0 ? adapter.get(0).nextElementSibling().text() : "";
    }
}
