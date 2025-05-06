package com.example.WebOath2.repository;

import com.example.WebOath2.entities.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends BaseRepository<UserRole,Long> {

    UserRole findByName(String name);

}
