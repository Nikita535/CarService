package com.example.carservice.controller;

import com.example.carservice.entity.Client;
import com.example.carservice.entity.Contract;
import com.example.carservice.repository.ContractRepository;
import com.example.carservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class OrderController {

    @Autowired
    private ContractRepository contractRepository;



    @ResponseBody
    @PostMapping(value = {"/order"})
    public String sendContract(@RequestBody Contract contract) {
        contract.setDateTime(LocalDateTime.now());
        contractRepository.save(contract);
        return "redirect:/";
    }

    @GetMapping(value = {"/order"})
    public String showContracts(Model model)
    {
        Client client=(Client) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("contracts",contractRepository.findByClient_Id(client.getId()));
        return "listingsTwo";
    }

    @ResponseBody
    @DeleteMapping("order/{id}")
    public boolean deleteContract(@PathVariable("id") Long id)
    {
        contractRepository.deleteById(id);
        return true;
    }
}
