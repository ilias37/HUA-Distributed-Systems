package gr.hua.dit.tax.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import gr.hua.dit.tax.entities.Actor;
import gr.hua.dit.tax.repository.ActorRepository;

@Controller
public class ActorFormController {

    @Autowired
    private ActorRepository actorRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/actorform")
    public String showActorForm(Model model) {
        Actor actor = new Actor();
        model.addAttribute("actor", actor);
        return "addActor";
    }

    @GetMapping("/actorlist")
    public String showActorList(Model model) {
        List<Actor> actors = actorRepository.findAll();
        model.addAttribute("actors", actors);
        return "actorList";
    }

    @PostMapping(path = "/actorform")
    public String saveActor(@ModelAttribute("actor") Actor actor) {
        actorRepository.save(actor);
        return "redirect:/";
    }

}