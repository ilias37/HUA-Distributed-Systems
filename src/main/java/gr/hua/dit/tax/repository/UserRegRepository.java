package gr.hua.dit.tax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gr.hua.dit.tax.entities.UserReg;

@Repository
public interface UserRegRepository extends JpaRepository<UserReg, Integer>{
    
}