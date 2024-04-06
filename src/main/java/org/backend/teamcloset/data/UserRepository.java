package org.backend.teamcloset.data;

import jakarta.persistence.Entity;
import org.backend.teamcloset.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
