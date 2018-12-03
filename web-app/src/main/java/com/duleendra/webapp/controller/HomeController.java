package com.duleendra.webapp.controller;

import com.duleendra.webapp.model.Product;
import com.duleendra.webapp.service.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webapp")
public class HomeController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/home")
    public List<Product> home() {
        return productClient.getProductList();
    }

}
