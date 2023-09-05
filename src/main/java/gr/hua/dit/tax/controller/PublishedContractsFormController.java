package gr.hua.dit.tax.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import gr.hua.dit.tax.entities.PublishedContracts;
import gr.hua.dit.tax.repository.ActorRepository;
import gr.hua.dit.tax.repository.NotaryRepository;
import gr.hua.dit.tax.repository.PublishedContractsRepository;

@Controller
public class PublishedContractsFormController {

    @Autowired
    private PublishedContractsRepository publishedContractsRepository;

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    NotaryRepository notaryRepository;

    //emfanizei mono ta sumvolaia pou summetexei o actor h o notary, o admin vlepei ta panta
    @GetMapping("/publishedcontractslist")
    public String showPublishedContractsList(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        if ( authentication.getAuthorities().stream().anyMatch( a -> a.getAuthority().equals("ROLE_ACTOR"))  ) {

            int id = actorRepository.findByUsername(username).getId();
            List<PublishedContracts> publishedContracts = publishedContractsRepository.findBySellerIdOrBuyerId(id , id);
            model.addAttribute("publishedContracts", publishedContracts);
            return "publishedContractsList";
        }
        else if ( authentication.getAuthorities().stream().anyMatch( a -> a.getAuthority().equals("ROLE_NOTARY") ) ){

            int id = notaryRepository.findByUsername(username).getId();
            List<PublishedContracts> publishedContracts = publishedContractsRepository.findByNotaryId(id);
            model.addAttribute("publishedContracts", publishedContracts);
            return "publishedContractsList";
        }
        else if ( authentication.getAuthorities().stream().anyMatch( a -> a.getAuthority().equals("ROLE_ADMIN") ) ) {

            List<PublishedContracts> publishedContracts = publishedContractsRepository.findAll();
            model.addAttribute("publishedContracts", publishedContracts);
            return "publishedContractsList";
        }
        else {
            return "publishedContractsList";
        }
    }
    
}