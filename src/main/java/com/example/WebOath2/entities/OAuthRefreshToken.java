package com.example.WebOath2.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "oauth_refresh_token")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OAuthRefreshToken implements Serializable {

    @Id
    private String tokenId;

    private String authenticationId;

//    @Lob
    private byte[] token;

//    @Lob
    private byte[] authentication;

    private String clientId;

}
