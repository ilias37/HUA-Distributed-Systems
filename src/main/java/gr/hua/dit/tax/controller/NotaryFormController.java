package gr.hua.dit.tax.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import gr.hua.dit.tax.entities.Notary;
import gr.hua.dit.tax.repository.NotaryRepository;

@Controller
public class NotaryFormController {

    @Autowired
    private NotaryRepository notaryRepository;

    @GetMapping("/notaryform")
    public String showNotaryForm(Model model) {
        Notary notary = new Notary();
        model.addAttribute("notary", notary);
        return "addNotary";
    }

    @GetMapping("/notarylist")
    public String showNotaryList(Model model) {
        List<Notary> notaries = notaryRepository.findAll();
        model.addAttribute("notaries", notaries);
        return "notaryList";
    }

    @PostMapping(path = "/notaryform")
    public String saveNotary(@ModelAttribute("notary") Notary notary) {
        notaryRepository.save(notary);
        return "redirect:/";
    }

}