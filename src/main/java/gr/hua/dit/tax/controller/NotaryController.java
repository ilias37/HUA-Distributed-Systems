package gr.hua.dit.tax.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import gr.hua.dit.tax.entities.Notary;
import gr.hua.dit.tax.repository.NotaryRepository;

@RestController
@RequestMapping("/notaries")
public class NotaryController {

    @Autowired
    NotaryRepository notaryRepository;

    @GetMapping("")
    public List<Notary> findAll(){
        return notaryRepository.findAll();
    }

    @PostMapping("")
    Notary save(@Validated @RequestBody Notary notary) {
        notary.setId(0);
        notaryRepository.save(notary);
        return notary;
    }

    @GetMapping("/{id}")
    Optional <Notary> findById(@PathVariable int id) {
        return notaryRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        notaryRepository.deleteById(id);
    }
    
}