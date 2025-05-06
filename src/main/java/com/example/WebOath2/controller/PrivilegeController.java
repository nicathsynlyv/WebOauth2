package com.example.WebOath2.controller;

import com.example.WebOath2.Service.PrivilegeService;
import com.example.WebOath2.entities.Privilege;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/privileges")
public class PrivilegeController {

    private final PrivilegeService privilegeService;

    public PrivilegeController(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }

    // Get all privileges
    @GetMapping
    public ResponseEntity<List<Privilege>> getAllPrivileges() {
        List<Privilege> privileges = privilegeService.getAll();
        return ResponseEntity.ok(privileges);
    }

    // Get privilege by ID
    @GetMapping("/{id}")
    public ResponseEntity<Privilege> getPrivilegeById(@PathVariable Long id) {
        Optional<Privilege> privilege = privilegeService.getById(id);
        return privilege.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new privilege
    @PostMapping
    public ResponseEntity<Privilege> createPrivilege(@RequestBody Privilege privilege) {
        Privilege savedPrivilege = privilegeService.save(privilege);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPrivilege);
    }

    // Update an existing privilege
    @PutMapping("/{id}")
    public ResponseEntity<Privilege> updatePrivilege(@PathVariable Long id, @RequestBody Privilege privilege) {
        if (privilegeService.getById(id).isPresent()) {
            privilege.setId(id);  // Ensure the id is set for update
            Privilege updatedPrivilege = privilegeService.save(privilege);
            return ResponseEntity.ok(updatedPrivilege);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete privilege by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrivilege(@PathVariable Long id) {
        if (privilegeService.getById(id).isPresent()) {
            privilegeService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Find privilege by name
//    @GetMapping("/name/{name}")
    public ResponseEntity<Privilege> getPrivilegeByName(@PathVariable String name) {
        Privilege privilege = privilegeService.findByName(name);
        if (privilege != null) {
            return ResponseEntity.ok(privilege);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}