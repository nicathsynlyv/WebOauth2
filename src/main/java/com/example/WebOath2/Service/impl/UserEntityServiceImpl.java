package com.example.WebOath2.Service.impl;

import com.example.WebOath2.Service.UserEntityService;
import com.example.WebOath2.entities.UserEntity;
import com.example.WebOath2.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntityServiceImpl implements UserEntityService {

    private final UserEntityRepository userEntityRepository;

    @Autowired
    public UserEntityServiceImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public List<UserEntity> getAll() {
        return userEntityRepository.findAll();
    }

    @Override
    public Optional<UserEntity> getById(Long id) {
        return userEntityRepository.findById(id);
    }

    @Override
    public UserEntity save(UserEntity entity) {
        return userEntityRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        userEntityRepository.deleteById(id);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userEntityRepository.findByUsername(username);
    }
}
