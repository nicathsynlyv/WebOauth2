package com.example.WebOath2.controller;

import com.example.WebOath2.Service.OAuthRefreshTokenService;
import com.example.WebOath2.entities.OAuthRefreshToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/oauth/refresh-tokens")
public class OAuthRefreshTokenController {

    private final OAuthRefreshTokenService refreshTokenService;

    public OAuthRefreshTokenController(OAuthRefreshTokenService refreshTokenService) {
        this.refreshTokenService = refreshTokenService;
    }

    // Get all refresh tokens
    @GetMapping
    public ResponseEntity<List<OAuthRefreshToken>> getAllRefreshTokens() {
        List<OAuthRefreshToken> refreshTokens = refreshTokenService.getAll();
        return ResponseEntity.ok(refreshTokens);
    }

    // Get refresh token by tokenId
    @GetMapping("/{tokenId}")
    public ResponseEntity<OAuthRefreshToken> getRefreshTokenById(@PathVariable String tokenId) {
        Optional<OAuthRefreshToken> refreshToken = refreshTokenService.getById(tokenId);
        return refreshToken.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new refresh token
    @PostMapping
    public ResponseEntity<OAuthRefreshToken> createRefreshToken(@RequestBody OAuthRefreshToken refreshToken) {
        OAuthRefreshToken savedRefreshToken = refreshTokenService.save(refreshToken);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRefreshToken);
    }

    // Delete refresh token by tokenId
    @DeleteMapping("/{tokenId}")
    public ResponseEntity<Void> deleteRefreshToken(@PathVariable String tokenId) {
        if (refreshTokenService.getById(tokenId).isPresent()) {
            refreshTokenService.deleteById(tokenId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Find refresh token by authenticationId
    @GetMapping("/authentication/{authenticationId}")
    public ResponseEntity<OAuthRefreshToken> getRefreshTokenByAuthenticationId(@PathVariable String authenticationId) {
        OAuthRefreshToken refreshToken = refreshTokenService.findByAuthenticationId(authenticationId);
        if (refreshToken != null) {
            return ResponseEntity.ok(refreshToken);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}