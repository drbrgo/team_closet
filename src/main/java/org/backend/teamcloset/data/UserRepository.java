package org.backend.teamcloset.data;

import jakarta.persistence.Entity;
import org.backend.teamcloset.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<User> findByUsername(String username);
}
