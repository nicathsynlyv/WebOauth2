package com.example.WebOath2.repository;

import com.example.WebOath2.entities.Privilege;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends BaseRepository<Privilege,Long> {
    Privilege findByName(String name);

}
