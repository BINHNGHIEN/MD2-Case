package com.company.controller;

import com.company.model.Product;
import com.company.service.product.ProductServiceIMPL;

import java.util.List;

public class ProductController {
    ProductServiceIMPL productServiceIMPL= new ProductServiceIMPL();
    public List<Product> showListProductPortfolio(){
        return productServiceIMPL.findAll();
    }
    public void createProduct( Product product){
        productServiceIMPL.save(product);
    }
    public void editProduct(int id, String name, double price,double quantity) {
        productServiceIMPL.edit(id,name,price,quantity);
    }
    public void deleteByIDProduct(int id){
        productServiceIMPL.deleteById(id);
    }
    public void searchProduct(int id) {
        productServiceIMPL.search(id);
    }
    public void searchProductByName(String name){
        productServiceIMPL.searchByName(name);
    }
    public void searchPrice(String name){
        productServiceIMPL.searchPrice(name);
    }

    public void sortByPriceMinMax(){
        productServiceIMPL.sortByPriceMinMax();
    }
    public void sortByPriceMaxMin(){
        productServiceIMPL.sortByPriceMaxMin();
    }
    public void sortBuyMaxMin(){
        productServiceIMPL.sortBuyMaxMin();
    }
    public void searchPriceRange( double minPrice, double maxPrice){
        productServiceIMPL.searchPriceRange(minPrice,maxPrice);
    }
    public List<Product> buyProduct(int id){
         return productServiceIMPL.buyProduct(id);
    }
    public List<Product> showListBuy(){
         return productServiceIMPL.showListBuy();
    }
}
