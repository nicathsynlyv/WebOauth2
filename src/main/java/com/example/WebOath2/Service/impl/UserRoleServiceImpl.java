package com.example.WebOath2.Service.impl;

import com.example.WebOath2.Service.UserRoleService;
import com.example.WebOath2.entities.UserRole;
import com.example.WebOath2.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public List<UserRole> getAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public Optional<UserRole> getById(Long id) {
        return userRoleRepository.findById(id);
    }

    @Override
    public UserRole save(UserRole entity) {
        return userRoleRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public UserRole findByName(String name) {
        return userRoleRepository.findByName(name);
    }
}