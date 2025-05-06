package com.example.WebOath2.repository;

import com.example.WebOath2.entities.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends BaseRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);

}
