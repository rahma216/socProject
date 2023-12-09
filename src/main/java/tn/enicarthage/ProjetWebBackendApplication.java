package tn.enicarthage;

import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.enicarthage.services.SoapService;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

@SpringBootApplication
public class ProjetWebBackendApplication implements CommandLineRunner {

	@Autowired
	private SoapService soapService;

	public static void main(String[] args) {
		System.setProperty("server.port", "8082");
		DOMConfigurator.configure("src/main/resources/log4j.xml");
		SpringApplication.run(ProjetWebBackendApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Specify the path to the XML file
		String xmlFilePath = "C:/Users/Acer/Downloads/cause2022.xml";

		// Read data from the XML file and send it as a SOAP request
		processXmlData(xmlFilePath);
	}

	private void processXmlData(String xmlFilePath) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(xmlFilePath));

			NodeList items = document.getElementsByTagName("item");

			for (int i = 0; i < items.getLength(); i++) {
				Element item = (Element) items.item(i);
				String labelle = item.getElementsByTagName("labelle").item(0).getTextContent();
				int accidents = Integer.parseInt(item.getElementsByTagName("accidents").item(0).getTextContent());
				int tues = Integer.parseInt(item.getElementsByTagName("tues").item(0).getTextContent());
				int blesses = Integer.parseInt(item.getElementsByTagName("blesses").item(0).getTextContent());

				// Send the data as a SOAP request
				soapService.processSoapRequest(labelle, accidents, tues, blesses);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
