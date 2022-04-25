package com.company.view;

import com.company.model.Role;
import com.company.model.RoleName;
import com.company.model.UserPrincipal;
import com.company.service.user_principal.UserPrincipalServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public Main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==================== MY NAVBAR ==========================");
        if(UserPrincipalServiceIMPL.userPrincipalList.size()==0){
            new RegisterOrLogin();
        } else {
            new ProfileView();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
