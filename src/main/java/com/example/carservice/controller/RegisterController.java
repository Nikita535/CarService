package com.example.carservice.controller;


import com.example.carservice.entity.Client;
import com.example.carservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("client")
public class RegisterController {

    @ModelAttribute("client")
    public Client client() {
        return new Client();
    }

    @Autowired
    private ClientService clientService;

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("client") Client client) {
        return clientService.validateRegister(client);
    }

}
