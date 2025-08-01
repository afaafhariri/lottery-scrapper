package com.lotteryscrapper.server.scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Scrapper implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        String url = "https://www.nlb.lk/lottery/jayoda";
        System.out.println("Fetching results from: " + url);
        try {
            Document doc = Jsoup.connect(url).get();
            Elements results = doc.select("ul.res li.lbox:nth-of-type(2) ol.B > li"); // Adjust this selector based on site
            System.out.println("Jayoda Lottery Results:");
            if (results.isEmpty()) {
                System.out.println("⚠️ No results found. HTML may be JS-rendered or changed.");
            } else {
                for (Element li : results) {
                    String title = li.attr("title");
                    String value = li.text().trim();
                    System.out.printf("→ %s: %s%n", title, value);
                }
            }
        } catch (Exception e) {
            System.err.println("Error fetching lottery results:");
            e.printStackTrace();
        }
    }
}
