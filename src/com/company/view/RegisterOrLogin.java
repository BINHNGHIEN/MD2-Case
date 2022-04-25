package com.company.view;

import java.util.Scanner;

public class RegisterOrLogin {
    Scanner scanner= new Scanner(System.in);
    public RegisterOrLogin(){
        System.out.println("1. REGISTER");
        System.out.println("2. LOGIN");
        System.out.println("3. Show list role");
        int  registerOrLogin= scanner.nextInt();
        switch (registerOrLogin){
            case 1:
                new RegisterView();
                break;
            case 2:
                new LoginView();
                break;
            case 3:
                new RoleView().showListRole();
                break;
        }
    }
}
