package com.example.WebOath2.Service;

import com.example.WebOath2.entities.OAuthRefreshToken;

public interface OAuthRefreshTokenService extends BaseService<OAuthRefreshToken,String>{
    OAuthRefreshToken findByAuthenticationId(String authenticationId);

}
