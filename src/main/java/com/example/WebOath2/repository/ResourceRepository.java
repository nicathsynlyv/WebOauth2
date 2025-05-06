package com.example.WebOath2.repository;

import com.example.WebOath2.entities.Resource;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends BaseRepository<Resource,Long> {
    Resource findByResourceName(String resourceName);

}
