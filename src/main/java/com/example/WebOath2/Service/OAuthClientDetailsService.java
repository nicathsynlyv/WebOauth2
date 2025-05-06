package com.example.WebOath2.Service;

import com.example.WebOath2.entities.OAuthClientDetails;

public interface OAuthClientDetailsService extends BaseService<OAuthClientDetails,String> {
    OAuthClientDetails findByClientId(String clientId);

}
