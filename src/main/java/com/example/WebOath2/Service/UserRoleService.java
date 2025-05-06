package com.example.WebOath2.Service;

import com.example.WebOath2.entities.UserRole;

public interface UserRoleService extends BaseService<UserRole,Long>{
    UserRole findByName(String name);

}
