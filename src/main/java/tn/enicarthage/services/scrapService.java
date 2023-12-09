/* tn.enicarthage.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicarthage.entities.scrap;
import tn.enicarthage.repositories.scrapRepo;

@Service
public class scrapService implements IscrapService {

    @Autowired
    private scrapRepo sp;

    @Override
    public void ajouterScrap(scrap s) {
        try {
            // Remplacez cette URL par l'URL du site web que vous souhaitez scraper
            String url = s.getUrl();

            // Récupérer le document HTML de l'URL spécifiée
            Document doc = Jsoup.connect(url).get();

            // Extraire le titre du site
            String title = doc.title();
            s.setTitre(title);

            // Extraire des informations spécifiques à partir de la balise avec l'ID "WxuNewsroom-meta-1869d024-e7ae-469b-8d1d-453aea8e6fe7"
            Element newsroomElement = doc.select("#WxuNewsroom-meta-1869d024-e7ae-469b-8d1d-453aea8e6fe7").first();

            if (newsroomElement != null) {
                String newsroomContent = newsroomElement.text();
                s.setContenu("Contenu de la balise avec l'ID WxuNewsroom-meta : " + newsroomContent);
            } else {
                s.setContenu("La balise avec l'ID WxuNewsroom-meta n'a pas été trouvée.");
            }

            // Enregistrez l'entité scrap dans la base de données
            sp.save(s);

        } catch (Exception e) {
            e.printStackTrace();
            // Gérez les erreurs ou enregistrez les informations dans les journaux selon vos besoins.
        }
    }
}
*/