package com.example.carservice.controller;

import com.example.carservice.entity.Client;
import com.example.carservice.entity.Contract;
import com.example.carservice.repository.PaymentTypeRepository;
import com.example.carservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PageController {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @GetMapping(value = {"/", "/index"})
    public String showMain(Model model) {
        model.addAttribute("user", (Client) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "listings";
    }

    @GetMapping(value = {"/contacts"})
    public String showContract(Model model, @RequestParam(value = "id",required = false) Optional<Long> id) {
        id.ifPresent(aLong -> model.addAttribute("car", productRepository.findProductById(aLong)));
        model.addAttribute("paymentType",paymentTypeRepository.findAll());
        model.addAttribute("contract",new Contract());
        model.addAttribute("user", (Client) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "contacts";
    }








}
