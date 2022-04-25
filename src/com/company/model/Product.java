package com.company.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private ProductPortfolio productPortfolio;

    public Product() {
    }

    public Product(int id, String name, double price, int quantity,ProductPortfolio productPortfolio) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity= quantity;
        this.productPortfolio = productPortfolio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductPortfolio getProductPortfolio() {
        return productPortfolio;
    }

    public void setProductPortfolio(ProductPortfolio productPortfolio) {
        this.productPortfolio = productPortfolio;
    }

    @Override
    public String toString() {
        return
                "id = " + id +"\n"+
                "name = " + name + "\n" +
                "price = " + price +"\n" +
                "quantity = " + quantity +"\n" +
                "productPortfolio : " + productPortfolio+"\n" ;
    }
}
