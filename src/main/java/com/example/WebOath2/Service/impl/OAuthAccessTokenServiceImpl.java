package com.example.WebOath2.Service.impl;


import com.example.WebOath2.Service.OAuthAccessTokenService;
import com.example.WebOath2.entities.OAuthAccessToken;
import com.example.WebOath2.repository.OAuthAccessTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OAuthAccessTokenServiceImpl implements OAuthAccessTokenService {

    private final OAuthAccessTokenRepository accessTokenRepository;

    @Autowired
    public OAuthAccessTokenServiceImpl(OAuthAccessTokenRepository accessTokenRepository) {
        this.accessTokenRepository = accessTokenRepository;
    }

    @Override
    public List<OAuthAccessToken> getAll() {
        return accessTokenRepository.findAll();
    }

    @Override
    public Optional<OAuthAccessToken> getById(String tokenId) {
        return accessTokenRepository.findById(tokenId);
    }

    @Override
    public OAuthAccessToken save(OAuthAccessToken entity) {
        return accessTokenRepository.save(entity);
    }

    @Override
    public void deleteById(String tokenId) {
        accessTokenRepository.deleteById(tokenId);
    }

    @Override
    public OAuthAccessToken findByAuthenticationId(String authenticationId) {
        return accessTokenRepository.findByAuthenticationId(authenticationId);
    }

    @Override
    public OAuthAccessToken findByUserName(String userName) {
        return accessTokenRepository.findByUserName(userName);
    }
}