package tn.enicarthage.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.enicarthage.entities.scrap;
@Repository
public interface scrapRepo extends CrudRepository<scrap, Long> {
}
