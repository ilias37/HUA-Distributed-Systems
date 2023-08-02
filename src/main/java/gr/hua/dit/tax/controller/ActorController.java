package gr.hua.dit.tax.controller;
 
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import gr.hua.dit.tax.entities.Actor;
import gr.hua.dit.tax.repository.ActorRepository;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    ActorRepository actorRepository;

    private EntityManager entityManager;


    @GetMapping("")
    public List<Actor> findAll(){
        return actorRepository.findAll();
    }

    @PostMapping("")
    Actor save(@Validated @RequestBody Actor actor) {
        actor.setId(0);
        actorRepository.save(actor);
        return actor;
    }
    
    @GetMapping("/{id}")
    Optional <Actor> findById(@PathVariable int id) {
        return actorRepository.findById(id);
    }

    @Transactional
    public Actor find(int id) {
        return entityManager.find(Actor.class, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
       actorRepository.deleteById(id);
    }
    
}