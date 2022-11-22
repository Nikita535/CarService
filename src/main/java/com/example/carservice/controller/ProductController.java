package com.example.carservice.controller;

import com.example.carservice.entity.Client;
import com.example.carservice.entity.Product;
import com.example.carservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private BodyTypeRepository bodyTypeRepository;

    @Autowired
    private CarMarkRepository carMarkRepository;


    @Autowired
    private EngineLayoutTypeRepository engineLayoutTypeRepository;

    @Autowired
    private EngineTypeRepository engineTypeRepository;

    @Autowired
    private ManufactureRepository manufactureRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = {"/edit"})
    public String showEditForm(Model model,@RequestParam(value = "id",required = false) Optional<Long> id) {
        id.ifPresent(aLong -> model.addAttribute("editCar", productRepository.findProductById(aLong)));
        model.addAttribute("carMarks", carMarkRepository.findAll());
        model.addAttribute("bodyTypes", bodyTypeRepository.findAll());
        model.addAttribute("engineTypes", engineTypeRepository.findAll());
        model.addAttribute("engineLayoutTypes", engineLayoutTypeRepository.findAll());
        model.addAttribute("manufactures", manufactureRepository.findAll());

        return "edit";
    }
//    @GetMapping(value = {"/delete"})
//    public String deleteProduct(Model model,@RequestParam(value = "id",required = false) Optional<Long> id) {
//        id.ifPresent(aLong -> productRepository.deleteById(aLong));
//        return "redirect:/";
//    }

    @ResponseBody
    @PostMapping(value = {"/create"})
    public Product createCar(@RequestBody Product product) {
        return productRepository.save(product);
    }
    @ResponseBody
    @PostMapping(value = {"/update/{id}"})
    public Product updateCar(@RequestBody Product product,@PathVariable("id") Long id) {
        Product productFromDb=productRepository.findProductById(id);
//        productFromDb.setCarMark(product.getCarMark());
//        productFromDb.getTechnicalDetails().setBodyType(product.getTechnicalDetails().getBodyType());
//        productFromDb.getTechnicalDetails().setDoorsNumber(product.getTechnicalDetails().getDoorsNumber());
        product.setId(productFromDb.getId());
        product.getTechnicalDetails().setId(productFromDb.getTechnicalDetails().getId());
        product.getTechnicalDetails().getEngineType().setId(productFromDb.getTechnicalDetails().getEngineType().getId());

        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public String showAllProducts(@PathVariable Long id, Model model) {
        model.addAttribute("user", (Client) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("car", productRepository.findProductById(id));
        return "detail";
    }

    @ResponseBody
    @GetMapping("/products")
    public List<Product> showAllProducts() {
        return productRepository.findAll();
    }
}
