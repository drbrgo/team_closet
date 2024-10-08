package org.backend.teamcloset.models.dto;

import java.util.Objects;

public class JwtAuthenticationResponse {

    private String token;

    private String refreshToken;

    public JwtAuthenticationResponse(String token, String refreshToken) {
        this.token = token;
        this.refreshToken = refreshToken;
    }

    public JwtAuthenticationResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}
