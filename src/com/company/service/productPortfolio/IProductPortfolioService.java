package com.company.service.productPortfolio;

import com.company.model.Product;
import com.company.model.ProductPortfolio;
import com.company.service.IServiceGeneric;
import com.company.service.IServiceGeneric;

import java.util.List;

public interface IProductPortfolioService  extends IServiceGeneric<ProductPortfolio> {
    List<ProductPortfolio> findAll();

    void save(ProductPortfolio productPortfolio);

    ProductPortfolio findById(int id);
    Product edit(int id, String name);
    Product deleteById( int id);
    Product search( int id);
    Product searchByName ( String name);

}
