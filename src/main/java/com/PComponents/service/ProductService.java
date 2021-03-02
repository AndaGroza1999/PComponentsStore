package com.PComponents.service;

import com.PComponents.model.Product;
import com.PComponents.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findByName(String name) {
        return productRepository.findAllByProductName(name);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
