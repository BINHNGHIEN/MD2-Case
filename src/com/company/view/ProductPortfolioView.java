package com.company.view;

import com.company.controller.ProductPortfolioController;
import com.company.model.ProductPortfolio;
import com.company.service.productPortfolio.ProductPortfolioServiceIMPL;

import java.util.List;
import java.util.Scanner;

public class ProductPortfolioView {
    Scanner scanner = new Scanner(System.in);
    ProductPortfolioController productPortfolioController = new ProductPortfolioController();
    List<ProductPortfolio> productPortfolioList = ProductPortfolioServiceIMPL.productPortfolioList;
    public void formCreateProductPortfolio(){
        while (true){
            int id;
            if(productPortfolioList.size()==0){
                id = 1;
            } else {
                id =  productPortfolioList.get(productPortfolioList.size()-1).getId()+1;
            }
            System.out.println("Enter the name Product portfolio: ");
            String name = scanner.nextLine();
            ProductPortfolio productPortfolio = new ProductPortfolio(id,name);
            productPortfolioController.createProductPortfolio(productPortfolio);
            System.out.println("Enter any key to continue create product portfolio or Enter QUIT to come back menu: ");
            String backMenu = scanner.nextLine();
            if(backMenu.equalsIgnoreCase("quit")){
                new Main();
            }
        }
    }


    public void formListProductPortfolio(){
        System.out.println(productPortfolioController.showListProductPortfolio());
        System.out.println("Enter QUIT to come back menu: ");
        String backMenu = scanner.nextLine();
        if(backMenu.equalsIgnoreCase("quit")){
            new Main();
        }
    }


    public void editProductPortfolio() {
        System.out.println("Enter Product Portfolio ID : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new name, enter skip if no change: ");
        String name = scanner.nextLine();
        if (name.equals("skip")) {
            for (int i = 0; i < productPortfolioList.size(); i++) {
                if (id == productPortfolioList.get(i).getId())
                    name = productPortfolioList.get(i).getName();
                }
        }
        productPortfolioController.editProductPO(id, name);
        new ProfileView();
    }

    public void deleteByIDProductPO() {
        System.out.println("Enter Product Portfolio ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        productPortfolioController.deleteByIDProductPO(id);
        new ProfileView();
    }

    public void searchProductPO() {
        System.out.println("Enter Product Portfolio ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        productPortfolioController.searchProductPO(id);
        System.out.println("Enter any key to continue create Product Portfolio or Enter QUIT to come back menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ProfileView();
        }
    }
    public void searchProductPOByName(){
        System.out.println("Enter Product Portfolio Name: ");
        String name = scanner.nextLine();
        productPortfolioController.searchProductByName(name);
        System.out.println("Enter any key to continue create Product Portfolio or Enter QUIT to come back menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ProfileView();
        }
    }

}
