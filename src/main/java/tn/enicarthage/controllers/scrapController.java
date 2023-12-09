/*package tn.enicarthage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.enicarthage.entities.scrap;
import tn.enicarthage.services.scrapService;

@RestController
@RequestMapping("/api")
public class scrapController {

    @Autowired
    private scrapService ss;

    @PostMapping("")
    public ResponseEntity<Void> ajouteruserForm(@RequestBody scrap s) {

        ss.ajouterScrap(s);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}*/
