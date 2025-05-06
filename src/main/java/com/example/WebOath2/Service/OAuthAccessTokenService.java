package com.example.WebOath2.Service;

import com.example.WebOath2.entities.OAuthAccessToken;

public interface OAuthAccessTokenService extends BaseService<OAuthAccessToken,String> {
    OAuthAccessToken findByAuthenticationId(String authenticationId);
    OAuthAccessToken findByUserName(String userName);
}
