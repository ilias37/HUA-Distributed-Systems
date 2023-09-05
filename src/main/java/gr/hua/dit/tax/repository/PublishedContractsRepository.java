package gr.hua.dit.tax.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gr.hua.dit.tax.entities.PublishedContracts;

@Repository
public interface PublishedContractsRepository extends JpaRepository<PublishedContracts, Integer>{
    
    List<PublishedContracts> findBySellerIdOrBuyerId(int id1, int id2);

    List<PublishedContracts> findByNotaryId(int id);

}