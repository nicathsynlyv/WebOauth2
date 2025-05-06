package com.example.WebOath2.repository;

import com.example.WebOath2.entities.OAuthRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuthRefreshTokenRepository extends JpaRepository<OAuthRefreshToken,String> {
    OAuthRefreshToken findByAuthenticationId(String authenticationId);

}
