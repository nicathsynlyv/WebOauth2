package com.example.WebOath2.Service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BaseService <T,K>{
    List<T> getAll();
    Optional<T> getById(K id);
    T save(T entity);
    void deleteById(K id);
}
