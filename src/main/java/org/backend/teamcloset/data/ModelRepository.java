package org.backend.teamcloset.data;

import org.backend.teamcloset.models.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}
