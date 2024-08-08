package org.backend.teamcloset.services;

import org.backend.teamcloset.entities.UserEntity;
import org.backend.teamcloset.models.dto.JwtAuthenticationResponse;
import org.backend.teamcloset.models.dto.RefreshTokenRequest;
import org.backend.teamcloset.models.dto.SignInRequest;
import org.backend.teamcloset.models.dto.SignUpRequest;

public interface AuthenticationService {

    UserEntity signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SignInRequest signInRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
