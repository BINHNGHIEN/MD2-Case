package com.company.view;

import com.company.controller.ProductController;
import com.company.controller.ProductPortfolioController;
import com.company.model.Product;
import com.company.model.ProductPortfolio;
import com.company.service.product.ProductServiceIMPL;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    Scanner scanner = new Scanner(System.in);
    ProductController productController = new ProductController();
    ProductPortfolioController productPortfolioController = new ProductPortfolioController();
    List<Product> productList = ProductServiceIMPL.productList;
    List<Product> productByList= ProductServiceIMPL.productBuyList;

    public ProductView() {
    }

    public void showListProduct() {
        System.out.println(productController.showListProductPortfolio());
        System.out.println("Enter QUIT to come back menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void showListBuy(){
        System.out.println(productController.showListBuy());
        System.out.println("Enter QUIT to come back menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void createProduct() {
        while (true) {
            int id;
            if (ProductServiceIMPL.productList.size() == 0) {
                id = 1;
            } else {
                id = productList.get(productList.size() - 1).getId() + 1;
            }
            System.out.println("Enter the name Product: ");
            String name = scanner.nextLine();
            System.out.println("Enter the price Product: ");
            int price = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the quantity Product: ");
            int quantity =Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the ID product Portfolio: ");
            int idClass = Integer.parseInt(scanner.nextLine());
            ProductPortfolio productPortfolio = productPortfolioController.findById(idClass);
            Product product = new Product(id, name, price,quantity, productPortfolio);
            productController.createProduct(product);
            System.out.println("Enter any key to continue create Product or Enter QUIT to come back menu: ");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }


    public void editProduct() {
        System.out.println("Enter Product ID : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new name, enter skip if no change: ");
        String name = scanner.nextLine();
        System.out.println("Enter new price, enter skip if no change: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new quantity, enter skip if no change: ");
        int quantity=Integer.parseInt(scanner.nextLine());

        if (name.equals("skip")) {
                for (int i = 0; i < productList.size(); i++) {
                    if (id == productList.get(i).getId())
                        name = productList.get(i).getName();
                }
        } else if (String.valueOf(price).equals("skip")) {
            for (int i = 0; i < productList.size(); i++) {
                if (id == productList.get(i).getId())
                    price = (int) productList.get(i).getPrice();
            }
        }else if (String.valueOf(quantity).equals("skip")) {
            for (int i = 0; i < productList.size(); i++) {
                if (id == productList.get(i).getId())
                    quantity = (int) productList.get(i).getPrice();
            }
        }

        productController.editProduct(id, name, price, quantity);

        new ProfileView();
    }

    public void deleteByIDProduct() {
        System.out.println("Enter Product ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        productController.deleteByIDProduct(id);

        new ProfileView();
    }

    public void searchProduct() {
        System.out.println("Enter Product ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        productController.searchProduct(id);
        System.out.println("Enter any key to continue create Product or Enter QUIT to come back menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ProfileView();
        }
    }

    public void searchProductByName(){
        System.out.println("Enter Product Name: ");
        String name = scanner.nextLine();
        productController.searchProductByName(name);
        System.out.println("Enter any key to continue create Product or Enter QUIT to come back menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ProfileView();
        }
    }
    public void searchPrice(){
        System.out.println("Enter Product Portfolio Name: ");
        String name = scanner.nextLine();
        productController.searchPrice(name);
        System.out.println("Enter any key to continue create Product or Enter QUIT to come back menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ProfileView();
        }
    }



    public void sortByPriceMinMax(){
        System.out.println(" Sort by Price Min Max");
        productController.sortByPriceMinMax();
        System.out.println(productList);
        System.out.println("Enter any key to continue create Product or Enter QUIT to come back menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }


    public void sortByPriceMaxMin(){
        System.out.println(" Sort by Price Max Min ");
        productController.sortByPriceMaxMin();
        System.out.println(productList);
        System.out.println("Enter any key to continue create Product or Enter QUIT to come back menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void sortBuyMaxMin(){
        System.out.println(" The Best seller ");
        productController.sortByPriceMaxMin();
        System.out.println(productByList.get(0));
        System.out.println("Enter any key to continue create Product or Enter QUIT to come back menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void searchPriceRange(){
        System.out.println(" Enter min Price");
        double minPrice = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter max Price");
        double maxPrice = Integer.parseInt((scanner.nextLine()));
        productController.searchPriceRange(minPrice,maxPrice);
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void buyProduct(){
        System.out.println("Enter Product ID : ");
        int id = Integer.parseInt(scanner.nextLine());
        productController.buyProduct(id);
        System.out.println(" Buy Successful");
        System.out.println("Enter any key to continue create Product or Enter QUIT to come back menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }
}