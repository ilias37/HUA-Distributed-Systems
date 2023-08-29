package gr.hua.dit.tax.controller;

import java.util.List;
import java.util.Optional;
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
    ContractRepository contractRepository;

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

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        contractRepository.deleteById(id);
    }

    // create/add a contract in a buyer
    @PostMapping("/{cid}/buyer")
    Actor addBuyer(@PathVariable int cid, @RequestBody Actor actor) {
        
        int actorId = actor.getId();
        Contract contract = contractRepository.getReferenceById(cid);

        if (contract == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Contract not found"
            );
        }

        if (actorId != 0) {
            Actor anActor = actorRepository.getReferenceById(actorId);
            contract.setBuyer(anActor);
            contractRepository.save(contract);
            return actor;
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid buyer ID");
    }

    // create/add a contract in a seller
    @PostMapping("/{cid}/seller")
    Actor addSeller(@PathVariable int cid, @RequestBody Actor actor) {
        
        int actorId = actor.getId();
        Contract contract = contractRepository.getReferenceById(cid);

        if (contract == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Contract not found"
            );
        }

        if (actorId != 0) {
            Actor anActor = actorRepository.getReferenceById(actorId);
            contract.setSeller(anActor);
            contractRepository.save(contract);
            return actor;
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid seller ID");
    }

}