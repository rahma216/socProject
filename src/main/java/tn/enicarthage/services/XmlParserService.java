package tn.enicarthage.services;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicarthage.entities.scrap;
import tn.enicarthage.repositories.scrapRepo;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Service
public class XmlParserService {

    @Autowired
    private scrapRepo accidentRepository;

    public List<scrap> getAllAccidents() {
        return (List<scrap>) accidentRepository.findAll();
    }
    public void parseXmlAndSaveToDatabase(String xmlFilePath) {
        try {
            Document document = Jsoup.parse(new File(xmlFilePath), "UTF-8");
            Elements items = document.select("item");

            for (Element item : items) {
                String labelle = item.select("labelle").text();
                int accidents = Integer.parseInt(item.select("accidents").text());
                int tues = Integer.parseInt(item.select("tues").text());
                int blesses = Integer.parseInt(item.select("blesses").text());

                scrap accidentEntity = new scrap();
                accidentEntity.setLabelle(labelle);
                accidentEntity.setAccidents(accidents);
                accidentEntity.setTues(tues);
                accidentEntity.setBlesses(blesses);

                accidentRepository.save(accidentEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
