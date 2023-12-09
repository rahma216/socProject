package tn.enicarthage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicarthage.entities.SoapRequest;
import tn.enicarthage.repositories.SoapRequestRepository;

import javax.jws.WebService;
import java.util.List;

@Service
public class SoapService {

    @Autowired
    private SoapRequestRepository soapRequestRepository;

    public void processSoapRequest(String labelle, int accidents, int tues, int blesses) {
        // Process the SOAP request data
        SoapRequest soapRequest = new SoapRequest();
        soapRequest.setLabelle(labelle);
        soapRequest.setAccidents(accidents);
        soapRequest.setTues(tues);
        soapRequest.setBlesses(blesses);

        // Save the SOAP request data to the database
        soapRequestRepository.save(soapRequest);
    }

    public List<SoapRequest> getAllSoapRequests() {
        return (List<SoapRequest>) soapRequestRepository.findAll();
    }
}