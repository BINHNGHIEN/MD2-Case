package com.company.view;

import com.company.model.Role;
import com.company.model.RoleName;
import com.company.model.UserPrincipal;
import com.company.service.user_principal.UserPrincipalServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ProfileView {
    Scanner scanner = new Scanner(System.in);

    List<UserPrincipal> userPrincipalList = UserPrincipalServiceIMPL.userPrincipalList;
    UserPrincipalServiceIMPL userPrincipalServiceIMPL = new UserPrincipalServiceIMPL();

    public ProfileView(){
        if(userPrincipalList.size()!=0){
            System.out.println("Welcome Profile: "+userPrincipalList.get(0).getName());
            System.out.println("1. LOG OUT");
        } else {
            System.out.println("Please Login! ");
        }
        List<UserPrincipal> userPrincipalList = UserPrincipalServiceIMPL.userPrincipalList;
        boolean checkLogin = false;

        if (userPrincipalList.size() != 0) {
            checkLogin = true;
        } else {
            checkLogin = false;
        }

        Set<Role> roleSet = userPrincipalList.get(0).getRoleSet();
        List<Role> roleList = new ArrayList<>(roleSet);
        boolean checkManager = roleList.get(0).getName() == RoleName.MANAGER;

        if (checkLogin) {
            if (checkManager) {
                System.out.println("2. Creat product portfolio");
                System.out.println("3. Show list product portfolio");
                System.out.println("4. CREATE PRODUCT");
                System.out.println("5. SHOW LIST PRODUCT");
                System.out.println("6. Edit Product");
                System.out.println("7. Delete by ID Product");
                System.out.println("8. Search by ID Product");
                System.out.println("9. Search by name Product");
                System.out.println("==============================");
                System.out.println("10. Edit Product Portfolio ");
                System.out.println("11. Delete by ID Product Portfolio ");
                System.out.println("12. Search by ID Product Portfolio ");
                System.out.println("13. Search by name  Product Portfolio ");
                System.out.println("================================");
                System.out.println("14. Show list user");
                System.out.println("15. sort Price MIN MAX");
                System.out.println("16. sort Price MAX MIN ");
                System.out.println("17. search price ");
                System.out.println("18. search price range ");
                System.out.println("19. Buy Product");
                System.out.println("20. Show List buy");
                System.out.println("21. Best seller ");

            } else {
                System.out.println("3. Show list product portfolio");
                System.out.println("5. SHOW LIST PRODUCT");
                System.out.println("8. Search by ID Product");
                System.out.println("9. Search by name Product");
                System.out.println("==============================");
                System.out.println("12. Search by ID Product Portfolio ");
                System.out.println("13. Search by name  Product Portfolio ");
                System.out.println("15. sort Price MIN MAX");
                System.out.println("16. sort Price MAX MIN ");
                System.out.println("17. search price ");
                System.out.println("18. search price range ");
                System.out.println("19. Buy Product");
                System.out.println("20. Show List buy");
                System.out.println("21. Best seller ");

            }
        }

        int chooseProfile = scanner.nextInt();
        switch (chooseProfile){
            case 1:
                logOut();
                new Main();
            case 2:
                if(checkManager){
                    new ProductPortfolioView().formCreateProductPortfolio();
                    break;
                } else {
                    System.err.println("Please try again");
                    new ProfileView();
                }
            case 3:
                new ProductPortfolioView().formListProductPortfolio();
                break;
            case 4:
                if(checkManager) {
                    new ProductView().createProduct();
                    break;
                } else {
                    System.err.println("Please try again");
                    new ProfileView();
                }
            case 5:
                new ProductView().showListProduct();
                break;
            case 6:
                if(checkManager) {
                    new ProductView().editProduct();
                    break;
                } else {
                    System.err.println("Please try again");
                    new ProfileView();
                }
            case 7:
                if(checkManager) {
                    new ProductView().deleteByIDProduct();
                    break;
                } else{
                    System.err.println("Please try again");
                    new ProfileView();
                }
            case 8 :
                new ProductView().searchProduct();
                break;
            case 9 :
                new ProductView().searchProductByName();
                break;
            case 10 :
                if(checkManager) {
                    new ProductPortfolioView().editProductPortfolio();
                    break;
                } else {
                    System.err.println("Please try again");
                    new ProfileView();
                }
            case 11 :
                if(checkManager) {
                    new ProductPortfolioView().deleteByIDProductPO();
                    break;
                } else {
                    System.err.println("Please try again");
                    new ProfileView();
                }
            case 12 :
                new ProductPortfolioView().searchProductPO();
                break;
            case 13 :
                new ProductPortfolioView().searchProductPOByName();
                break;
            case 14 :
                if(checkManager) {
                    new ListUserView();
                    break;
                } else {
                    System.err.println("Please try again");
                    new ProfileView();
                }
            case 15 :
                new ProductView().sortByPriceMinMax();
                break;
            case 16 :
                new ProductView().sortByPriceMaxMin();
                break;
            case 17 :
                new ProductView().searchPrice();
                break;
            case 18:
                new ProductView().searchPriceRange();
            case 19 :
                new ProductView().buyProduct();
                break;
            case 20 :
                new ProductView().showListBuy();
                break;
            case 21 :
                new ProductView().sortBuyMaxMin();
                break;

        }
        String backMenu = scanner.nextLine();
        if(backMenu.equalsIgnoreCase("quit")){
            new Main();
        }
    }

    public  void logOut(){
        UserPrincipalServiceIMPL.userPrincipalList.clear();
        userPrincipalServiceIMPL.findAll();
    }
}
