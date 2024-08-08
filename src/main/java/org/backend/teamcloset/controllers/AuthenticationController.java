package org.backend.teamcloset.controllers;

import org.backend.teamcloset.entities.UserEntity;
import org.backend.teamcloset.models.dto.JwtAuthenticationResponse;
import org.backend.teamcloset.models.dto.RefreshTokenRequest;
import org.backend.teamcloset.models.dto.SignInRequest;
import org.backend.teamcloset.models.dto.SignUpRequest;
import org.backend.teamcloset.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:3000")

//no required args lombok constructor. check constructor!!

public class AuthenticationController {

    //inject authenticationservice
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/signup")
    public ResponseEntity<UserEntity> signup(@RequestBody SignUpRequest signUpRequest) {

        return ResponseEntity.ok(authenticationService.signup(signUpRequest));

    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest signInRequest) {

        return ResponseEntity.ok(authenticationService.signin(signInRequest));

    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {

        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));

    }

}
