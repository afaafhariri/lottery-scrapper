package com.lotteryscrapper.server.scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
            Elements results = doc.select(".lottery-result span"); // Adjust this selector based on site

            System.out.println("Jayoda Lottery Results:");
            results.forEach(e -> System.out.println("→ " + e.text()));
        } catch (Exception e) {
            System.err.println("Error fetching lottery results:");
            e.printStackTrace();
        }
    }
}
