package org.backend.teamcloset.data;

import org.backend.teamcloset.entities.UserEntity;
import org.backend.teamcloset.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    UserEntity findByRole(Role role);

}
