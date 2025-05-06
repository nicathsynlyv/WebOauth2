package com.example.WebOath2.Service.impl;

import com.example.WebOath2.Service.ResourceService;
import com.example.WebOath2.entities.Resource;
import com.example.WebOath2.repository.ResourceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public List<Resource> getAll() {
        return resourceRepository.findAll();
    }

    @Override
    public Optional<Resource> getById(Long id) {
        return resourceRepository.findById(id);
    }

    @Override
    public Resource save(Resource entity) {
        return resourceRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        resourceRepository.deleteById(id);
    }

    @Override
    public Resource findByResourceName(String resourceName) {
        return resourceRepository.findByResourceName(resourceName);
    }
}
