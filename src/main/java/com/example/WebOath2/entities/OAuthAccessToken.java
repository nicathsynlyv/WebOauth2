package com.example.WebOath2.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "oauth_access_token")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OAuthAccessToken implements Serializable {

    @Id
    private String tokenId;

    private String authenticationId;

//    @Lob
    @Column(columnDefinition = "bytea")
    private byte[] token;

//    @Lob
    @Column(columnDefinition = "bytea")
    private byte[] authentication;

    private String userName;

    private String clientId;

    private String refreshToken;
}

