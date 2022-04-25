package com.company.service.user;

import com.company.dto.SignInDTO;
import com.company.model.User;
import com.company.service.IServiceGeneric;

public interface IUserService extends IServiceGeneric<User> {
    boolean existedByUsername(String username);
    boolean checkLogin(String username, String password);
    User findByUsername(String username);
}
