package com.company.service.role;

import com.company.model.Role;
import com.company.model.RoleName;
import com.company.service.IServiceGeneric;

public interface IRoleService extends IServiceGeneric<Role> {
    Role findByName(RoleName name);
}
