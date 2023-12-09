package tn.enicarthage.controllers;

import tn.enicarthage.entities.SoapRequest;
import tn.enicarthage.services.SoapService;

import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/soap")
@WebService(targetNamespace = "http://rahma.com")
public class SoapController {

    @Inject
    private SoapService soapService;

    @GET
    @Path("/getAllRequests")
    @WebMethod
    public List<SoapRequest> getAllSoapRequests() {
        return soapService.getAllSoapRequests();
    }

    @POST
    @Path("/process")
    @WebMethod
    public String processSoapRequest(@WebParam(name = "labelle") String labelle,
                                     @WebParam(name = "accidents") int accidents,
                                     @WebParam(name = "tues") int tues,
                                     @WebParam(name = "blesses") int blesses) {
        try {
            soapService.processSoapRequest(labelle, accidents, tues, blesses);
            return "SOAP request processed successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to process SOAP request";
        }
    }
}
