package com.duleendra.productservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController{

    @GetMapping("/")
    public ResponseEntity<List> productList() {
        List list = new ArrayList();
        list.add("Apple Watch");
        list.add("Monitor");
        list.add("Hand bag");

        return new ResponseEntity<>(list, HttpStatus.OK);

    }
}
