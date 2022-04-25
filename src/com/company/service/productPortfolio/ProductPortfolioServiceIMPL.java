package com.company.service.productPortfolio;

import com.company.config.ConfigReadAndWriteFile;
import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Product;
import com.company.model.ProductPortfolio;

import java.util.ArrayList;
import java.util.List;

import static com.company.service.product.ProductServiceIMPL.PATH_PRODUCT;

public class ProductPortfolioServiceIMPL implements IProductPortfolioService{
    public static String PATH_PRODUCT_PO = ConfigReadAndWriteFile.PATH+"productPortfolio.txt";
    public static List<ProductPortfolio> productPortfolioList=  new ConfigReadAndWriteFile<ProductPortfolio>().readFromFile(PATH_PRODUCT_PO);
    public static List<Product> productList=  new ConfigReadAndWriteFile<Product>().readFromFile(PATH_PRODUCT);

    @Override
    public List<ProductPortfolio> findAll() {
        new ConfigReadAndWriteFile<ProductPortfolio>().writeToFile(PATH_PRODUCT_PO,productPortfolioList);
        return productPortfolioList;
    }

    @Override
    public void save(ProductPortfolio productPortfolio) {
        productPortfolioList.add(productPortfolio);

    }

    @Override
    public ProductPortfolio findById(int id) {
        for ( int i=0;i<productPortfolioList.size();i++)
            if(id==productPortfolioList.get(i).getId()){
                return productPortfolioList.get(i);
            }
        return null;
    }

    @Override
    public Product edit(int id, String name) {
        for (int i = 0; i < productPortfolioList.size(); i++) {
            if (id == productPortfolioList.get(i).getId()){
                productPortfolioList.get(i).setName(name);
            }
        }
        new ConfigReadAndWriteFile<ProductPortfolio>().writeToFile(PATH_PRODUCT_PO,productPortfolioList);
        return null;
    }

    @Override
    public Product deleteById(int id) {
        for (int i = 0; i < productPortfolioList.size(); i++) {
            if (id == productPortfolioList.get(i).getId()){
                productPortfolioList.remove(i);
            }
        }
        new ConfigReadAndWriteFile<ProductPortfolio>().writeToFile(PATH_PRODUCT_PO, productPortfolioList);
        return null;
    }

    @Override
    public Product search(int id) {
        for (int i = 0; i < productPortfolioList.size(); i++) {
            if (id == productPortfolioList.get(i).getId()){
                System.out.println(productPortfolioList.get(i));
            }
        }
        return null;
    }

    @Override
    public Product searchByName(String name) {
        List<ProductPortfolio> searchList = new ArrayList<>();
        for (int i = 0; i < productPortfolioList.size(); i++) {
            if (productPortfolioList.get(i).getName().equals(name)){
                searchList.add(productPortfolioList.get(i));
            }
        }
        System.out.println(searchList);
        return null;
    }
}
