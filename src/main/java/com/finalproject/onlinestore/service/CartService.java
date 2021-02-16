package com.finalproject.onlinestore.service;

import com.finalproject.onlinestore.model.Product;
import com.finalproject.onlinestore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;


//    public boolean removeFromCart(Product product) {
//
//        return productList.remove(product);
//    }
//
//    public double totalCart() {
//        double total = 0;
//
//        for (Product p : productList) {
//            total += p.getProductPrice();
//        }
//        return total;
//    }

}
