package gr.hua.dit.tax.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import gr.hua.dit.tax.entities.Contract;
import gr.hua.dit.tax.repository.ContractRepository;

@Controller
public class ContractFormController {

    @Autowired
    private ContractRepository contractRepository;

    @GetMapping("/contractform")
    public String showContractForm(Model model) {
        Contract contract = new Contract();
        model.addAttribute("contract", contract);
        return "addContract";
    }

    @GetMapping("/contractlist")
    public String showContractList(Model model) {
        List<Contract> contracts = contractRepository.findAll();
        model.addAttribute("contracts", contracts);
        return "contractList";
    }

    @PostMapping(path = "/contractform")
    public String saveContract(@ModelAttribute("contract") Contract contract) {
        contractRepository.save(contract);
        return "redirect:/";
    }

}