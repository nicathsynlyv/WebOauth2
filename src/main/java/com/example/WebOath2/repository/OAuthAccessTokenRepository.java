package com.example.WebOath2.repository;

import com.example.WebOath2.entities.OAuthAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuthAccessTokenRepository extends JpaRepository<OAuthAccessToken, String> {
    OAuthAccessToken findByAuthenticationId(String authenticationId);
    OAuthAccessToken findByUserName(String userName);

}
