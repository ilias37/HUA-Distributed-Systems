package gr.hua.dit.tax.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import gr.hua.dit.tax.entities.Actor;
import gr.hua.dit.tax.entities.Contract;
import gr.hua.dit.tax.entities.Notary;
import gr.hua.dit.tax.repository.ActorRepository;
import gr.hua.dit.tax.repository.ContractRepository;
import gr.hua.dit.tax.repository.NotaryRepository;

@Controller
public class ContractFormController {

    @Autowired
    private ContractRepository contractRepository;
    
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    NotaryRepository notaryRepository;

    @GetMapping("/contractform")
    public String showContractForm(Model model) {
        Contract contract = new Contract();
        model.addAttribute("contract", contract);
        return "addContract";
    }
 
    //emfanizei mono ta sumvolaia pou summetexei o actor h o notary, o admin vlepei ta panta
    @GetMapping("/contractlist")
    public String showContractList(Model model) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        if ( authentication.getAuthorities().stream().anyMatch( a -> a.getAuthority().equals("ROLE_ACTOR"))  ) {

            Actor actor = actorRepository.findByUsername(username);
            List<Contract> contracts = contractRepository.findBySellerOrBuyer(actor, actor);
            model.addAttribute("contracts", contracts);
            return "contractList";
        }
        else if ( authentication.getAuthorities().stream().anyMatch( a -> a.getAuthority().equals("ROLE_NOTARY") ) ){

            Notary notary = notaryRepository.findByUsername(username);
            List<Contract> contracts = contractRepository.findByNotary(notary);
            model.addAttribute("contracts", contracts);
            return "contractList";
        }
        else if ( authentication.getAuthorities().stream().anyMatch( a -> a.getAuthority().equals("ROLE_ADMIN") ) ) {
            
            List<Contract> contracts = contractRepository.findAll();
            model.addAttribute("contracts", contracts);
            return "contractList";
        }
        else {
            return "contractList";
        }

    }    

    @PostMapping(path = "/contractform")
    public String saveContract(@ModelAttribute("contract") Contract contract) {
        contractRepository.save(contract);
        return "redirect:/";
    }

}