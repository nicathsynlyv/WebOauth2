package com.example.WebOath2.Service.impl;


import com.example.WebOath2.Service.PrivilegeService;
import com.example.WebOath2.entities.Privilege;
import com.example.WebOath2.repository.PrivilegeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    private final PrivilegeRepository privilegeRepository;

    @Autowired
    public PrivilegeServiceImpl(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    @Override
    public List<Privilege> getAll() {
        return privilegeRepository.findAll();
    }

    @Override
    public Optional<Privilege> getById(Long id) {
        return privilegeRepository.findById(id);
    }

    @Override
    public Privilege save(Privilege entity) {
        return privilegeRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        privilegeRepository.deleteById(id);
    }

    @Override
    public Privilege findByName(String name) {
        return privilegeRepository.findByName(name);
    }
}