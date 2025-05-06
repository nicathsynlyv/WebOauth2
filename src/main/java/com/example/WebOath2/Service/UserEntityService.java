package com.example.WebOath2.Service;

import com.example.WebOath2.entities.UserEntity;

public interface UserEntityService extends  BaseService<UserEntity,Long> {
    UserEntity findByUsername(String username);

}
