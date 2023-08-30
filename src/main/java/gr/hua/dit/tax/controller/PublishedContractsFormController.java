package gr.hua.dit.tax.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import gr.hua.dit.tax.entities.PublishedContracts;
import gr.hua.dit.tax.repository.PublishedContractsRepository;

@Controller
public class PublishedContractsFormController {

 @Autowired
    private PublishedContractsRepository publishedContractsRepository;

    @GetMapping("/publishedcontractslist")
    public String showPublishedContractsList(Model model) {
        List<PublishedContracts> publishedContracts = publishedContractsRepository.findAll();
        model.addAttribute("publishedContracts", publishedContracts);
        return "publishedContractsList";
    }
    
}