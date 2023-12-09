// SoapRequestRepository.java
package tn.enicarthage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enicarthage.entities.SoapRequest;

public interface SoapRequestRepository extends JpaRepository<SoapRequest, Long> {
}
