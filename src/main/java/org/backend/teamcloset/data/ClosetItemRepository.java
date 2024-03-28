package org.backend.teamcloset.data;

import org.backend.teamcloset.models.ClosetItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClosetItemRepository extends JpaRepository <ClosetItemEntity, Long> {
    Iterable <ClosetItemEntity> findBySize(String size);
    Iterable <ClosetItemEntity> findBySeries(String series);
    Iterable <ClosetItemEntity> findByGender(String gender);
    Iterable <ClosetItemEntity> findBySeason(String season);
    Iterable <ClosetItemEntity> findByBodyPart(String bodyPart);
    List <ClosetItemEntity> findBySizeAndSeries(String size, String series);
    List<ClosetItemEntity> findBySizeAndSeriesAndGender(String size, String series, String gender);
    List<ClosetItemEntity> findBySizeAndSeriesAndGenderAndSeason(String size, String series, String gender, String season);
    List<ClosetItemEntity> findBySizeAndSeriesAndGenderAndSeasonAndBodyPart(String size, String series, String gender, String season, String bodyPart);
    List<ClosetItemEntity> findBySizeAndGender(String size, String gender);
    List<ClosetItemEntity> findBySizeAndSeason(String size, String season);
    List<ClosetItemEntity> findBySizeAndBodyPart(String size, String bodyPart);
    List<ClosetItemEntity> findBySeriesAndGender(String series, String gender);
    List<ClosetItemEntity> findBySeriesAndSeason(String series, String season);
    List<ClosetItemEntity> findBySeriesAndBodyPart(String series, String bodyPart);
    List<ClosetItemEntity> findByGenderAndSeason(String gender, String season);
    List<ClosetItemEntity> findByGenderAndBodyPart(String gender, String bodyPart);
    List<ClosetItemEntity> findBySeasonAndBodyPart(String season, String bodyPart);
    List<ClosetItemEntity> findBySizeAndSeriesAndSeason(String size, String series, String season);
    List<ClosetItemEntity> findBySizeAndSeriesAndBodyPart(String size, String series, String bodyPart);
    List<ClosetItemEntity> findBySizeAndGenderAndSeason(String size, String gender, String season);
    List<ClosetItemEntity> findBySizeAndGenderAndBodyPart(String size, String gender, String bodyPart);
    List<ClosetItemEntity> findBySeriesAndGenderAndSeason(String series, String gender, String season);
    List<ClosetItemEntity> findBySeriesAndGenderAndBodyPart(String series, String gender, String bodyPart);
    List<ClosetItemEntity> findByGenderAndSeasonAndBodyPart(String gender, String season, String bodyPart);
    List<ClosetItemEntity> findBySeriesAndGenderAndSeasonAndBodyPart(String series, String gender, String season, String bodyPart);
    List<ClosetItemEntity> findBySizeAndGenderAndSeasonAndBodyPart(String size, String gender, String season, String bodyPart);
    List<ClosetItemEntity> findBySizeAndSeriesAndSeasonAndBodyPart(String size, String series, String season, String bodyPart);
    List<ClosetItemEntity> findBySizeAndSeriesAndGenderAndBodyPart(String size, String series, String gender, String bodyPart);

}
