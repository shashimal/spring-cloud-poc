package com.duleendra.productservice.controller;

import com.duleendra.productservice.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/")
    public ResponseEntity<List<Product>> productList() {


        List list = new ArrayList();
        list.add(new Product(1L, "Apple Watch", "Apple Watch"));
        list.add(new Product(2L, "Monitor", "Monitor"));
        list.add(new Product(3L, "Hand bag", "Hand bag"));

        return new ResponseEntity<>(list, HttpStatus.OK);

    }
}
