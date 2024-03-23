package org.backend.teamcloset.data;

import org.backend.teamcloset.models.ClosetItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClosetItemRepository extends JpaRepository <ClosetItemEntity, Long> {
    Iterable <ClosetItemEntity> findBySize(String size);
}
