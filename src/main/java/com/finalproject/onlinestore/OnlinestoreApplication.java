package com.finalproject.onlinestore;

import com.finalproject.onlinestore.controller.ProductController;
import com.finalproject.onlinestore.model.Cart;
import com.finalproject.onlinestore.model.Product;
import com.finalproject.onlinestore.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlinestoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinestoreApplication.class, args);

        //Product product = new Product("Name", 123.00, false, "Info");
    }
}
