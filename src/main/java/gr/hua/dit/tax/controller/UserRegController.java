package gr.hua.dit.tax.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import gr.hua.dit.tax.entities.UserReg;
import gr.hua.dit.tax.repository.UserRegRepository;

@RestController
@RequestMapping("/userReg")
public class UserRegController {

    @Autowired
    UserRegRepository userRegRepository;

    @GetMapping("")
    public List<UserReg> findAll(){
        return userRegRepository.findAll();
    }

    @PostMapping("")
    UserReg save(@Validated @RequestBody UserReg userReg) {
        userReg.setId(0);
        userRegRepository.save(userReg);
        return userReg;
    }
    
    @GetMapping("/{id}")
    Optional <UserReg> findById(@PathVariable int id) {
        return userRegRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
       userRegRepository.deleteById(id);
    }
    
}