package gr.hua.dit.tax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import gr.hua.dit.tax.entities.Actor;
import gr.hua.dit.tax.entities.Notary;
import gr.hua.dit.tax.entities.UserReg;
import gr.hua.dit.tax.repository.ActorRepository;
import gr.hua.dit.tax.repository.NotaryRepository;
import gr.hua.dit.tax.repository.UserRegRepository;

@Controller
public class RegController {

    @Autowired
    JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private NotaryRepository notaryRepository;

    @Autowired
    private UserRegRepository userRegRepository;

    //Gia registration tou Seller/Buyer
    //Emfanish formas
    @RequestMapping(value = "/registersb", method = RequestMethod.GET)
    public ModelAndView registerSellerBuyer() {
        return new ModelAndView("registerSellerBuyer", "user", new UserReg());
    }

    @RequestMapping(value = "/registersb", method = RequestMethod.POST)
    public ModelAndView processRegisterSB(@ModelAttribute("user") UserReg userRegObj) {

        //authorities to be granted 
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ACTOR"));

        //Gemisma ston User afou prwta krathsw username kai password
        User user = new User(userRegObj.getUsername(), passwordEncoder.encode(userRegObj.getPassword()), authorities);
        jdbcUserDetailsManager.createUser(user);
 
        // Gemisma ston Actor afou prwta krathsw firstName, lastName, email
        Actor actor = new Actor(userRegObj.getUsername(), userRegObj.getFirstName(), userRegObj.getLastName(), userRegObj.getEmail());
        actorRepository.save(actor);

        // UserReg userRegObj1 = new UserReg(userRegObj.getUsername(), 
        //                                   userRegObj.getFirstName(), 
        //                                   userRegObj.getLastName(), 
        //                                   userRegObj.getEmail(), 
        //                                   passwordEncoder.encode(userRegObj.getPassword()), 
        //                                   "ROLE_ACTOR");

        // userRegRepository.save(userRegObj1);

        return new ModelAndView("redirect:/");
    }

    //Gia registration tou Notary
    //Emfanish formas
    @RequestMapping(value = "/registern", method = RequestMethod.GET)
    public ModelAndView registerNotary() {
        return new ModelAndView("registerNotary", "user", new UserReg());
    }

    @RequestMapping(value = "/registern", method = RequestMethod.POST)
    public ModelAndView processRegisterN(@ModelAttribute("user") UserReg userRegObj) {

        //authorities to be granted
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_NOTARY"));

        //Gemisma ston User afou prwta krathsw username kai password
        User user = new User(userRegObj.getUsername(), passwordEncoder.encode(userRegObj.getPassword()), authorities);
        jdbcUserDetailsManager.createUser(user);

        //Gemisma ston Notary afou prwta krathsw firstName, lastName, email
        Notary notary = new Notary(userRegObj.getUsername(), userRegObj.getFirstName(), userRegObj.getLastName(), userRegObj.getEmail());
        notaryRepository.save(notary);

        // UserReg userRegObj1 = new UserReg(userRegObj.getUsername(), 
        //                                   userRegObj.getFirstName(), 
        //                                   userRegObj.getLastName(), 
        //                                   userRegObj.getEmail(), 
        //                                   passwordEncoder.encode(userRegObj.getPassword()), 
        //                                   "ROLE_NOTARY");
                                          
        // userRegRepository.save(userRegObj1);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {

        if (error != null)
            model.addAttribute("errorMsg", "Try again, please.");

        if (logout != null)
            model.addAttribute("msg", "Logout Done");

        return "login";
    }
}