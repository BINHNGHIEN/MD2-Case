package com.company.service.product;

import com.company.model.Product;
import com.company.service.IServiceGeneric;

import java.util.List;

public interface IProductService  extends IServiceGeneric<Product> {
    Product findById(int id);
    Product edit(int id, String name, double price,double quantity );
    Product deleteById( int id);
    Product search( int id);
    Product searchByName ( String name);
    Product searchPrice ( String name);
    Product searchPriceRange(double minPrice, double maxPrice);
    List<Product> buyProduct(int id);
    List<Product> showListBuy();

    void sortByPriceMinMax ();
    void sortByPriceMaxMin ();
    void sortBuyMaxMin();

}
