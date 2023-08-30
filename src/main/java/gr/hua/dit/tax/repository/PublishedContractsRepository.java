package gr.hua.dit.tax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gr.hua.dit.tax.entities.PublishedContracts;

@Repository
public interface PublishedContractsRepository extends JpaRepository<PublishedContracts, Integer>{
    
}