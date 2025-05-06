package com.example.WebOath2.Service.impl;

import com.example.WebOath2.Service.OAuthRefreshTokenService;
import com.example.WebOath2.entities.OAuthRefreshToken;
import com.example.WebOath2.repository.OAuthRefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class OAuthRefreshTokenServiceImpl implements OAuthRefreshTokenService {

    private final OAuthRefreshTokenRepository refreshTokenRepository;

    @Autowired
    public OAuthRefreshTokenServiceImpl(OAuthRefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Override
    public List<OAuthRefreshToken> getAll() {
        return refreshTokenRepository.findAll();
    }

    @Override
    public Optional<OAuthRefreshToken> getById(String tokenId) {
        return refreshTokenRepository.findById(tokenId);
    }

    @Override
    public OAuthRefreshToken save(OAuthRefreshToken entity) {
        return refreshTokenRepository.save(entity);
    }

    @Override
    public void deleteById(String tokenId) {
        refreshTokenRepository.deleteById(tokenId);
    }

    @Override
    public OAuthRefreshToken findByAuthenticationId(String authenticationId) {
        return refreshTokenRepository.findByAuthenticationId(authenticationId);
    }
}