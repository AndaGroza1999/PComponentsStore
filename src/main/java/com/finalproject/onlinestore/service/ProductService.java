package com.finalproject.onlinestore.service;

import com.finalproject.onlinestore.model.Product;
import com.finalproject.onlinestore.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public ProductService() {
    }

    public Product addToCart(Product product) {
        return productRepo.save(product);
    }

}