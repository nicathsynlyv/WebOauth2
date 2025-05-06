package com.example.WebOath2.controller;


import com.example.WebOath2.Service.OAuthAccessTokenService;
import com.example.WebOath2.entities.OAuthAccessToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/oauth/access-tokens")
public class OAuthAccessTokenController {

    private final OAuthAccessTokenService accessTokenService;

    public OAuthAccessTokenController(OAuthAccessTokenService accessTokenService) {
        this.accessTokenService = accessTokenService;
    }

    // Get all access tokens
    @GetMapping
    public ResponseEntity<List<OAuthAccessToken>> getAllAccessTokens() {
        List<OAuthAccessToken> accessTokens = accessTokenService.getAll();
        return ResponseEntity.ok(accessTokens);
    }

    // Get access token by tokenId
    @GetMapping("/{tokenId}")
    public ResponseEntity<OAuthAccessToken> getAccessTokenById(@PathVariable String tokenId) {
        Optional<OAuthAccessToken> accessToken = accessTokenService.getById(tokenId);
        return accessToken.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new access token
    @PostMapping
    public ResponseEntity<OAuthAccessToken> createAccessToken(@RequestBody OAuthAccessToken accessToken) {
        OAuthAccessToken savedAccessToken = accessTokenService.save(accessToken);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAccessToken);
    }

    // Delete access token by tokenId
    @DeleteMapping("/{tokenId}")
    public ResponseEntity<Void> deleteAccessToken(@PathVariable String tokenId) {
        if (accessTokenService.getById(tokenId).isPresent()) {
            accessTokenService.deleteById(tokenId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Find access token by authenticationId
    @GetMapping("/authentication-id/{authenticationId}")
    public ResponseEntity<OAuthAccessToken> getAccessTokenByAuthenticationId(@PathVariable String authenticationId) {
        OAuthAccessToken accessToken = accessTokenService.findByAuthenticationId(authenticationId);
        if (accessToken != null) {
            return ResponseEntity.ok(accessToken);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Find access token by userName
    @GetMapping("/user-name/{userName}")
    public ResponseEntity<OAuthAccessToken> getAccessTokenByUserName(@PathVariable String userName) {
        OAuthAccessToken accessToken = accessTokenService.findByUserName(userName);
        if (accessToken != null) {
            return ResponseEntity.ok(accessToken);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
