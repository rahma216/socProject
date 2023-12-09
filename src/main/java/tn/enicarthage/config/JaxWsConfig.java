package tn.enicarthage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import tn.enicarthage.services.SoapService;

@Configuration
public class JaxWsConfig {

    @Bean
    public SoapService jaxWsSoapService() {
        return new SoapService();
    }

    @Bean
    public SimpleJaxWsServiceExporter jaxWsExporter() {
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://localhost:8082/");
        return exporter;
    }
}
