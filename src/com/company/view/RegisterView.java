package com.company.view;

import com.company.config.ConfigReadAndWriteFile;
import com.company.controller.UserController;
import com.company.dto.SignUpDTO;
import com.company.model.Role;
import com.company.service.role.RoleServiceIMPL;
import com.company.service.user.UserServiceIMPL;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

import static com.company.service.role.RoleServiceIMPL.PATH_ROLE;
import static com.company.service.role.RoleServiceIMPL.roleList;

public class RegisterView {
    Scanner scanner = new Scanner(System.in);
    UserController userController = new UserController();
    UserServiceIMPL userServiceIMPL = new UserServiceIMPL();


    public  RegisterView(){
        new RoleServiceIMPL().findAll();
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter username: ");
        String username;
        boolean checkUsername;
        while (true){
            username = scanner.nextLine();
            checkUsername = Pattern.matches("[a-z0-9_-]{6,}",username);
            if(!checkUsername){
                System.err.println("Username Failed! Please try again!");
            }else if(userServiceIMPL.existedByUsername(username)){
                System.err.println("Username is existed! Please try again!");
            } else {
                break;
            }
        }
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Enter your role");
        String role = scanner.nextLine();
        Set<String> strRole = new HashSet<>();
        strRole.add(role);
        SignUpDTO signUpDTO = new SignUpDTO(name,username,password,strRole);
        userController.register(signUpDTO);
        new LoginView();

    }
}
