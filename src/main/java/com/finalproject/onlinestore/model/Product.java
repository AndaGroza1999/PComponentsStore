package com.finalproject.onlinestore.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    private Long idProduct;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productPrice")
    private Double productPrice;

    //daca e in stock sau nu
    @Column(name = "isInStock")
    private boolean isInStock;

    @Column(name = "productInformation")
    private String productInformation;


    public Product() {
    }

    public Product(String productName, Double productPrice, boolean isInStock, String productInformation) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.isInStock = isInStock;
        this.productInformation = productInformation;
    }


    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return isInStock == product.isInStock &&
                productName.equals(product.productName) &&
                productPrice.equals(product.productPrice) &&
                productInformation.equals(product.productInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productPrice, isInStock, productInformation);
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + idProduct +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", isInStock=" + isInStock +
                ", productInformation='" + productInformation + '\'' +
                '}';
    }

}
