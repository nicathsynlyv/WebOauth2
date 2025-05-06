package com.example.WebOath2.controller;

import com.example.WebOath2.Service.UserRoleService;
import com.example.WebOath2.entities.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    // Constructor dependency injection
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    // Get all roles
    @GetMapping
    public List<UserRole> getAllRoles() {
        return userRoleService.getAll();
    }

    // Get role by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserRole> getRoleById(@PathVariable Long id) {
        Optional<UserRole> role = userRoleService.getById(id);
        return role.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Save new role
    @PostMapping
    public ResponseEntity<UserRole> createRole(@RequestBody UserRole userRole) {
        UserRole savedRole = userRoleService.save(userRole);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRole);
    }

    // Delete role by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        if (userRoleService.getById(id).isPresent()) {
            userRoleService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Find role by name
    @GetMapping("/name/{name}")
    public ResponseEntity<UserRole> getRoleByName(@PathVariable String name) {
        UserRole role = userRoleService.findByName(name);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}