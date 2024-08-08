package org.backend.teamcloset.services.implementation;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.backend.teamcloset.services.JWTService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

//all methods for generating JWT or extracting data from it
@Service
public class JWTServiceImplementation implements JWTService {

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                //expires in 1 day
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                //need to look into signaturealgorithm, why hs256 and not default es256?
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                //expires in 7 days
                .setExpiration(new Date(System.currentTimeMillis() + 604800000))
                //need to look into signaturealgorithm, why hs256 and not default es256?
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers ) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    private Key getSigninKey() {
        //minimum length of at least 256 bits
        byte [] key = Decoders.BASE64.decode("NDEzRjQ0Mjg0NzJCNEI2MjUwNjU1MzY4NTY2RDU5NzAzMzczMzY3NjM5NzkyNDQyMjY0NTI5NDg0MDRENjM1MQ==");
        return Keys.hmacShaKeyFor(key);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigninKey()).build().parseClaimsJws(token).getBody();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        System.out.println("username of token is " + username);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        //checks expiration against current date/time
        return extractClaim(token, Claims::getExpiration).before(new Date());

    }
}
