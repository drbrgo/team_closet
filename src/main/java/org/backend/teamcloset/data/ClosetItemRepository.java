package org.backend.teamcloset.data;

import org.backend.teamcloset.models.ClosetItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClosetItemRepository extends JpaRepository <ClosetItemEntity, Long> {
    Iterable <ClosetItemEntity> findBySize(String size);
    Iterable <ClosetItemEntity> findBySeries(String series);
    List <ClosetItemEntity> findBySizeAndSeries(String size, String series);
}
