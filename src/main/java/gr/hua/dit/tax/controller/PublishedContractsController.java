package gr.hua.dit.tax.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gr.hua.dit.tax.entities.PublishedContracts;
import gr.hua.dit.tax.repository.PublishedContractsRepository;

@RestController
@RequestMapping("/publishedcontracts")
public class PublishedContractsController {

    @Autowired
    PublishedContractsRepository publishedContractsRepository;

    @GetMapping("")
    public List<PublishedContracts> findAll(){
        return publishedContractsRepository.findAll();
    }

    @PostMapping("")
    PublishedContracts save(@Validated @RequestBody PublishedContracts publishedContract) {
        publishedContract.setId(0);
        publishedContractsRepository.save(publishedContract);
        return publishedContract;
    }

    @GetMapping("/{id}")
    Optional <PublishedContracts> findById(@PathVariable int id) {
        return publishedContractsRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        publishedContractsRepository.deleteById(id);
    }
}