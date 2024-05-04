package org.backend.teamcloset.services;

import io.jsonwebtoken.Claims;
import org.backend.teamcloset.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

public interface JWTService {

    String extractUsername(String token);

    String generateToken(UserDetails userDetails);

    String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);

}
