package gr.hua.dit.tax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gr.hua.dit.tax.entities.Notary;

@Repository
public interface NotaryRepository extends JpaRepository<Notary, Integer>{

    Notary findByUsername(String username);
    
}