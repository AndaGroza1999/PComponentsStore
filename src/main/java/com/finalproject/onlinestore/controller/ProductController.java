package com.finalproject.onlinestore.controller;

import com.finalproject.onlinestore.model.Product;
import com.finalproject.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        product = new Product("nae", 123.2, false, "123");
        return productService.addToCart(product);
    }
}
