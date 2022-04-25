package com.company.service.product;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Product;

import java.util.*;

public class ProductServiceIMPL implements IProductService{
    public static String PATH_PRODUCT= ConfigReadAndWriteFile.PATH+ "product.txt";
    public static String PATH_PRODUCT_CART= ConfigReadAndWriteFile.PATH+ "cart.txt";
    public static List<Product> productList= new ConfigReadAndWriteFile<Product>().readFromFile(PATH_PRODUCT);
    public static List<Product> productBuyList= new ConfigReadAndWriteFile<Product>().readFromFile(PATH_PRODUCT_CART);




    @Override
    public List<Product> findAll() {
        new ConfigReadAndWriteFile<Product>().writeToFile(PATH_PRODUCT,productList);
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
        new ConfigReadAndWriteFile<Product>().writeToFile(PATH_PRODUCT,productList);
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public Product edit(int id, String name, double price, double quantity) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()){
                productList.get(i).setName(name);
                productList.get(i).setPrice(price);
                productList.get(i).setQuantity((int) quantity);
            }
        }
        new ConfigReadAndWriteFile<Product>().writeToFile(PATH_PRODUCT, productList);
        return null;
    }

    @Override
    public Product deleteById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()){
                productList.remove(i);
            }
        }
        new ConfigReadAndWriteFile<Product>().writeToFile(PATH_PRODUCT, productList);
        return null;
    }

    @Override
    public Product search(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()){
                System.out.println(productList.get(i));
            }
        }
        return null;
    }

    @Override
    public Product searchByName(String name) {
        List<Product> searchList = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(name)){
                searchList.add(productList.get(i));
            }
        }
        System.out.println(searchList);
        return null;
    }
    @Override
    public Product searchPrice(String name) {
        List<Product> searchPrice = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductPortfolio().getName().equals(name)){
                searchPrice.add(productList.get(i));
            }
        }
        System.out.println(searchPrice);
        return null;
    }
    @Override
    public Product searchPriceRange(double minPrice, double maxPrice) {
        for (int i = 0; i < productList.size(); i++) {
            if (minPrice <= productList.get(i).getPrice()&&maxPrice>=productList.get(i).getPrice()){
                System.out.println(productList.get(i));
            }
        }
        return null;
    }

    @Override
    public List<Product>  buyProduct(int id) {

        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()){
                productList.get(i).setQuantity(productList.get(i).getQuantity()-1);
                for (int j = 0; j < productBuyList.size(); j++) {
                    if (id==productBuyList.get(j).getId()){
                        productBuyList.get(j).setQuantity(productBuyList.get(j).getQuantity()+1);
                        new ConfigReadAndWriteFile<Product>().writeToFile(PATH_PRODUCT_CART,productBuyList);
                        return productBuyList;
                    }
                }

                productBuyList.add(productList.get(i));
                productBuyList.get(i).setQuantity(1);
               findAll();

               new ConfigReadAndWriteFile<Product>().writeToFile(PATH_PRODUCT_CART,productBuyList);
            }
        }
        return productBuyList;
    }


    @Override
    public List<Product> showListBuy() {
        new ConfigReadAndWriteFile<Product>().writeToFile(PATH_PRODUCT_CART,productBuyList);
        return  productBuyList;

    }

    @Override
    public void sortByPriceMinMax() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice()-o2.getPrice());
            }
        });
    }

    @Override
    public void sortByPriceMaxMin() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o2.getPrice()-o1.getPrice());
            }
        });
    }

    @Override
    public void sortBuyMaxMin() {
        Collections.sort(productBuyList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o2.getQuantity()-o1.getQuantity());
            }
        });
    }

}
