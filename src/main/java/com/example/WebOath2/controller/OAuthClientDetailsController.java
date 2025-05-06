package com.example.WebOath2.controller;


import com.example.WebOath2.Service.OAuthClientDetailsService;
import com.example.WebOath2.entities.OAuthClientDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/oauth/client-details")
public class OAuthClientDetailsController {

    private final OAuthClientDetailsService clientDetailsService;

    public OAuthClientDetailsController(OAuthClientDetailsService clientDetailsService) {
        this.clientDetailsService = clientDetailsService;
    }

    // Get all client details
    @GetMapping
    public ResponseEntity<List<OAuthClientDetails>> getAllClientDetails() {
        List<OAuthClientDetails> clientDetails = clientDetailsService.getAll();
        return ResponseEntity.ok(clientDetails);
    }

    // Get client details by clientId
    @GetMapping("/{clientId}")
    public ResponseEntity<OAuthClientDetails> getClientDetailsById(@PathVariable String clientId) {
        Optional<OAuthClientDetails> clientDetails = clientDetailsService.getById(clientId);
        return clientDetails.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new client detail
    @PostMapping
    public ResponseEntity<OAuthClientDetails> createClientDetail(@RequestBody OAuthClientDetails clientDetails) {
        OAuthClientDetails savedClientDetails = clientDetailsService.save(clientDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClientDetails);
    }

    // Delete client details by clientId
    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClientDetail(@PathVariable String clientId) {
        if (clientDetailsService.getById(clientId).isPresent()) {
            clientDetailsService.deleteById(clientId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Find client details by clientId
    @GetMapping("/client-id/{clientId}")
    public ResponseEntity<OAuthClientDetails> getClientDetailsByClientId(@PathVariable String clientId) {
        OAuthClientDetails clientDetails = clientDetailsService.findByClientId(clientId);
        if (clientDetails != null) {
            return ResponseEntity.ok(clientDetails);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}