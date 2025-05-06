package com.example.WebOath2.repository;

import com.example.WebOath2.entities.OAuthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuthClientDetailsRepository extends JpaRepository<OAuthClientDetails,String> {
    OAuthClientDetails findByClientId(String clientId);

}
