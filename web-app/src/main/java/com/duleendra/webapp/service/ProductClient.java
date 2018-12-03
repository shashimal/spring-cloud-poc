package com.duleendra.webapp.service;

import com.duleendra.webapp.model.Product;
import com.duleendra.webapp.response.ProductResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductClient {

    private final RestTemplate restTemplate;

    @Autowired
    public ProductClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getDefaultProductList")
    public List<Product> getProductList() {
        ResponseEntity<List<Product>> productResponse =
                restTemplate.exchange("http://product-service/products/",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
                        });

        List<Product> products = null;
        if (productResponse.getStatusCode() == HttpStatus.OK) {
            products = productResponse.getBody();
        } else {
            System.out.println("Error");
        }

        return products;
    }

    @SuppressWarnings("unused")
    public List<Product> getDefaultProductList() {
        Product product = new Product(1L, "Empty", "Empty");
        List<Product> products = new ArrayList<>();
        products.add(product);
        return products;
    }
}
