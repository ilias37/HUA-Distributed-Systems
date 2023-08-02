package gr.hua.dit.tax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gr.hua.dit.tax.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
    
}