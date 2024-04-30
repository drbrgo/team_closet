package org.backend.teamcloset.services.implementation;

import org.backend.teamcloset.data.UserRepository;
import org.backend.teamcloset.entities.UserEntity;
import org.backend.teamcloset.entities.Role;
import org.backend.teamcloset.models.dto.SignUpRequest;
import org.backend.teamcloset.services.AuthenticationService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImplementation implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserEntity signup(SignUpRequest signUpRequest) {
        UserEntity user = new UserEntity();

        user.setUsername(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setRole(Role.USER);

        return userRepository.save(user);

    }

    public AuthenticationServiceImplementation(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
}
