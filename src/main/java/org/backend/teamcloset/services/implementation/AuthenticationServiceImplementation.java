package org.backend.teamcloset.services.implementation;

import org.backend.teamcloset.data.UserRepository;
import org.backend.teamcloset.entities.UserEntity;
import org.backend.teamcloset.entities.Role;
import org.backend.teamcloset.models.dto.JwtAuthenticationResponse;
import org.backend.teamcloset.models.dto.RefreshTokenRequest;
import org.backend.teamcloset.models.dto.SignInRequest;
import org.backend.teamcloset.models.dto.SignUpRequest;
import org.backend.teamcloset.services.AuthenticationService;
import org.backend.teamcloset.services.JWTService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthenticationServiceImplementation implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JWTService jwtService;

    public UserEntity signup(SignUpRequest signUpRequest) {
        UserEntity user = new UserEntity();

        user.setUsername(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setRole(Role.USER);

        return userRepository.save(user);

    }

    public AuthenticationServiceImplementation(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JWTService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public JwtAuthenticationResponse signin(SignInRequest signInRequest){
        //verify and validate username and password
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));

        System.out.println("username: "+signInRequest.getUsername()+" password: "+signInRequest.getPassword());
        var user = userRepository.findByUsername(signInRequest.getUsername()).orElseThrow(
                () -> new IllegalArgumentException("Try again. Username or password is invalid!"));

        var jwt = jwtService.generateToken(user);

        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);

        jwtAuthenticationResponse.setRefreshToken(refreshToken);

        return jwtAuthenticationResponse;

    }

    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {

        String username = jwtService.extractUsername(refreshTokenRequest.getToken());

        UserEntity user = userRepository.findByUsername(username).orElseThrow();

        //checks if user equals user in database
        if(jwtService.isTokenValid(refreshTokenRequest.getToken(), user)) {
            //creates new token with updated expiration date
            var jwt = jwtService.generateToken(user);

            //send response
            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthenticationResponse;

        }

        //if token is not valid then return null
        return null;
    }
}
