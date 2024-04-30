package org.backend.teamcloset.controllers;

import org.backend.teamcloset.entities.UserEntity;
import org.backend.teamcloset.models.dto.SignUpRequest;
import org.backend.teamcloset.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
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

}
