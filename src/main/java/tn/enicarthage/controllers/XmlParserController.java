package tn.enicarthage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.entities.scrap;
import tn.enicarthage.repositories.scrapRepo;
import tn.enicarthage.services.XmlParserService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class XmlParserController {

    @Autowired
    private XmlParserService xmlParserService;




    @GetMapping("/accidents")
    public ResponseEntity<List<scrap>> getAllAccidents() {
        List<scrap> accidents = xmlParserService.getAllAccidents();
        return new ResponseEntity<>(accidents, HttpStatus.OK);
    }
}
