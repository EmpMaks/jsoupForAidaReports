package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            //document.select("td:contains(Операционная система)")
            Document document = Jsoup.parse(new File("src/main/resources/Бахматович(юрист) Вера.htm"));
            Elements divHeader = document.select("body > table > tbody > tr > td");
            Element a = divHeader.get(61);
            System.out.println(a.text());

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Hello World!");
    }
}
