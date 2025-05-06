package com.example.WebOath2.controller;

import com.example.WebOath2.Service.ResourceService;
import com.example.WebOath2.entities.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resources")

public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    // Get all resources
    @GetMapping
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.getAll();
        return ResponseEntity.ok(resources);
    }

    // Get resource by ID
    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id) {
        Optional<Resource> resource = resourceService.getById(id);
        return resource.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new resource
    @PostMapping
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
        Resource savedResource = resourceService.save(resource);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedResource);
    }

    // Update an existing resource
    @PutMapping("/{id}")
    public ResponseEntity<Resource> updateResource(@PathVariable Long id, @RequestBody Resource resource) {
        if (resourceService.getById(id).isPresent()) {
            resource.setId(id);  // Ensure the id is set for update
            Resource updatedResource = resourceService.save(resource);
            return ResponseEntity.ok(updatedResource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete resource by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long id) {
        if (resourceService.getById(id).isPresent()) {
            resourceService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Find resource by resource name
    @GetMapping("/name/{resourceName}")
    public ResponseEntity<Resource> getResourceByName(@PathVariable String resourceName) {
        Resource resource = resourceService.findByResourceName(resourceName);
        if (resource != null) {
            return ResponseEntity.ok(resource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}