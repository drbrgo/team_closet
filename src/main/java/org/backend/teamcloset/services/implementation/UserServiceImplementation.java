package org.backend.teamcloset.services.implementation;

import org.backend.teamcloset.data.UserRepository;
import org.backend.teamcloset.entities.UserEntity;
import org.backend.teamcloset.services.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//required args constructor lombok
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                System.out.println("username "+ username + " not found");
//                return null;
                System.out.println("Attempting to load user by username: " + username);
                Optional<UserEntity> userOptional = userRepository.findByUsername(username);
                UserEntity user = userOptional.orElseThrow(() -> {
                    System.out.println("User not found: " + username);
                    return new UsernameNotFoundException("User not found");
                });

                System.out.println("User found: " + username);
                return
                        //new CustomUserDetails(user); // CustomUserDetails should implement UserDetails
                        User.withUsername(user.getUsername())
                                .password(user.getPassword())
//                                .authorities("USER") // Modify this as needed
                                .accountExpired(false)
                                .accountLocked(false)
                                .credentialsExpired(false)
                                .disabled(false)
                                .build();

            }
        };
    }
}
