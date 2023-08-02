package gr.hua.dit.tax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gr.hua.dit.tax.entities.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer>{
    
}