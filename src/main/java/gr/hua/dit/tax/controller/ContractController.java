package gr.hua.dit.tax.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import gr.hua.dit.tax.entities.Actor;
import gr.hua.dit.tax.entities.Contract;
import gr.hua.dit.tax.repository.ActorRepository;
import gr.hua.dit.tax.repository.ContractRepository;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    ActorController actorController;

    Contract contract;
 
    @Autowired
    ContractRepository contractRepository;

    @Autowired
    private EntityManager entityManager;

    @GetMapping("")
    public List<Contract> findAll(){
        return contractRepository.findAll();
    }

    @PostMapping("")
    Contract save(@Validated @RequestBody Contract contract) {
        contract.setId(0);
        contractRepository.save(contract);
        return contract;
    }

    @GetMapping("/{id}")
    Optional <Contract> findById(@PathVariable int id) {
        return contractRepository.findById(id);
    }

    @Transactional
    public Contract find(int id) {
        return entityManager.find(Contract.class, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        contractRepository.deleteById(id);
    }

    @PostMapping("/{cid}/buyer")
    Actor addActor(@PathVariable int cid, @RequestBody Actor actor) {
        
        int actorId = actor.getId();
        Contract contract = find(cid);

        if (contract == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found");
        }

        if (actorId != 0) {
            Actor anActor = actorController.find(actorId);
            contract.setActor(anActor);
            actorRepository.save(actor);
            return anActor;
        }

        contract.setActor(actor);
        actorRepository.save(actor);
        return actor;

    }

}