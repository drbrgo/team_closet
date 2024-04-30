package org.backend.teamcloset.services;

import org.backend.teamcloset.entities.UserEntity;
import org.backend.teamcloset.models.dto.SignUpRequest;

public interface AuthenticationService {

    UserEntity signup(SignUpRequest signUpRequest);

}
