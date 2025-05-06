package com.example.WebOath2.Service.impl;

import com.example.WebOath2.Service.OAuthClientDetailsService;
import com.example.WebOath2.entities.OAuthClientDetails;
import com.example.WebOath2.repository.OAuthClientDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OAuthClientDetailsServiceImpl implements OAuthClientDetailsService {

    private final OAuthClientDetailsRepository clientDetailsRepository;

    @Autowired
    public OAuthClientDetailsServiceImpl(OAuthClientDetailsRepository clientDetailsRepository) {
        this.clientDetailsRepository = clientDetailsRepository;
    }

    @Override
    public List<OAuthClientDetails> getAll() {
        return clientDetailsRepository.findAll();
    }

    @Override
    public Optional<OAuthClientDetails> getById(String clientId) {
        return clientDetailsRepository.findById(clientId);
    }

    @Override
    public OAuthClientDetails save(OAuthClientDetails entity) {
        return clientDetailsRepository.save(entity);
    }

    @Override
    public void deleteById(String clientId) {
        clientDetailsRepository.deleteById(clientId);
    }

    @Override
    public OAuthClientDetails findByClientId(String clientId) {
        return clientDetailsRepository.findByClientId(clientId);
    }
}