package gr.hua.dit.tax.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gr.hua.dit.tax.entities.Actor;
import gr.hua.dit.tax.entities.Contract;
import gr.hua.dit.tax.entities.Notary;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer>{

    List<Contract> findBySellerOrBuyer(Actor actor1, Actor actor2);

    List<Contract> findByNotary(Notary notary);

}