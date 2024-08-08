package org.backend.teamcloset.controllers;

import org.apache.coyote.Response;
import org.backend.teamcloset.data.ClosetItemRepository;
import org.backend.teamcloset.models.ClosetItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/api/v1/auth/closet")
public class ClosetController {

    @Autowired
    ClosetItemRepository closetItemRepository;

    @GetMapping("/getclosetitems")
    public ResponseEntity<?> displayClosetItems (
            @RequestParam(required = false)String size,
            @RequestParam(required = false)String selectSeries,
            @RequestParam(required = false)String gender,
            @RequestParam(required = false)String season,
            @RequestParam(required = false)String bodyPart
    ){
        //intellij shows that sizeFilter is always null; network tab shows that fetch url
        // does have the '?param=xxs' appended if xxs is selected
        //is it because the request param is named sizeFilter here and param on the front end?
        //yes--also needed to change closetitemrepository method findbysize to return an iterable
        //not a single closetitemobject

        //trying to circumnavigate findby stacking issues by creating an iterable and then looping through it to find
        //all instances where series=selectSeries -- this doesn't work either... something is up
        //all the trouble was caused by the http request formatted with a '?' instead of a '&' between two query params

        Iterable<ClosetItemEntity> sizeFilteredClosetItems = closetItemRepository.findBySize(size);
        ArrayList<ClosetItemEntity> targetClosetItems = new ArrayList<ClosetItemEntity>();

        if (size == null && selectSeries == null && gender == null && season == null && bodyPart == null) {
            System.out.println("size, series, gender, season and part are all null");

            return new ResponseEntity<>(closetItemRepository.findAll(), HttpStatus.OK);

        } else if(selectSeries == null && size != null && gender == null && season == null && bodyPart == null) {
            System.out.println("everything but size is null");
            return new ResponseEntity<>(sizeFilteredClosetItems, HttpStatus.OK);

        } else if(size == null && selectSeries == null && gender != null && season == null && bodyPart == null) {
            System.out.println("everything but gender is null");
            return new ResponseEntity<>(closetItemRepository.findByGender(gender), HttpStatus.OK);

        } else if(size == null && selectSeries == null && gender == null && season != null && bodyPart == null) {
            System.out.println("everything but season is null");
            return new ResponseEntity<>(closetItemRepository.findBySeason(season), HttpStatus.OK);

        }else if(size == null && selectSeries == null && gender == null && season == null && bodyPart != null) {
            System.out.println("everything but bodypart is null");
            return new ResponseEntity<>(closetItemRepository.findByBodyPart(bodyPart), HttpStatus.OK);

        }else if(size != null && selectSeries != null && gender != null && season != null && bodyPart == null) {
            System.out.println("searching size series gender season");
            return new ResponseEntity<>(closetItemRepository.findBySizeAndSeriesAndGenderAndSeason(size, selectSeries, gender, season), HttpStatus.OK);

        }else if(size != null && selectSeries != null && gender != null && season != null && bodyPart != null) {
            System.out.println("everything has value");
            return new ResponseEntity<>(closetItemRepository.findBySizeAndSeriesAndGenderAndSeasonAndBodyPart(size, selectSeries, gender, season, bodyPart), HttpStatus.OK);

        }else if(size != null && selectSeries == null && gender != null && season == null && bodyPart == null) {
            System.out.println("everything but size and gender is null");
            return new ResponseEntity<>(closetItemRepository.findBySizeAndGender(size, gender), HttpStatus.OK);

        }else if(size != null && selectSeries== null && gender == null && season != null && bodyPart == null) {
            System.out.println("everything but size and season is null");
            return new ResponseEntity<>(closetItemRepository.findBySizeAndSeason(size, season), HttpStatus.OK);

        }else if(size != null && selectSeries == null && gender == null && season == null && bodyPart != null) {
            System.out.println("everything but size and bodypart is null");
            return new ResponseEntity<>(closetItemRepository.findBySizeAndBodyPart(size, bodyPart), HttpStatus.OK);

        }else if(size == null && selectSeries != null && gender != null && season == null && bodyPart == null) {
            System.out.println("everything but series and gender is null");
            return new ResponseEntity<>(closetItemRepository.findBySeriesAndGender(selectSeries, gender), HttpStatus.OK);

        }else if(size == null && selectSeries != null && gender == null && season != null && bodyPart == null) {
            System.out.println("everything but series and season is null");
            return new ResponseEntity<>(closetItemRepository.findBySeriesAndSeason(selectSeries, season), HttpStatus.OK);

        }else if(size == null && selectSeries != null && gender == null && season == null && bodyPart != null) {
            System.out.println("everything but series and bodypart is null");
            return new ResponseEntity<>(closetItemRepository.findBySeriesAndBodyPart(selectSeries, bodyPart), HttpStatus.OK);

        }else if(size == null && selectSeries == null && gender != null && season != null && bodyPart == null) {
            System.out.println("everything but gender and season is null");
            return new ResponseEntity<>(closetItemRepository.findByGenderAndSeason(gender, season), HttpStatus.OK);

        }else if(size == null && selectSeries == null && gender != null && season == null && bodyPart != null) {
            System.out.println("everything but gender and bodypart is null");
            return new ResponseEntity<>(closetItemRepository.findByGenderAndBodyPart(gender, bodyPart), HttpStatus.OK);

        }else if(size == null && selectSeries == null && gender == null && season != null && bodyPart != null) {
            System.out.println("everything but season and bodypart is null");
            return new ResponseEntity<>(closetItemRepository.findBySeasonAndBodyPart(season, bodyPart), HttpStatus.OK);

        }else if(size != null && selectSeries != null && gender == null && season != null && bodyPart == null) {
            System.out.println("everything but size series and season is null");
            return new ResponseEntity<>(closetItemRepository.findBySizeAndSeriesAndSeason(size, selectSeries, season), HttpStatus.OK);

        }else if(size != null && selectSeries != null && gender == null && season == null && bodyPart != null) {
            System.out.println("everything but size series and bodypart is null");
            return new ResponseEntity<>(closetItemRepository.findBySizeAndSeriesAndBodyPart(size, selectSeries, bodyPart), HttpStatus.OK);

        }else if(size != null && selectSeries == null && gender != null && season != null && bodyPart == null) {
            System.out.println("everything but size gender and season is null");
            return new ResponseEntity<>(closetItemRepository.findBySizeAndGenderAndSeason(size, gender, season), HttpStatus.OK);

        }else if(size != null && selectSeries == null && gender != null && season == null && bodyPart != null) {
            System.out.println("everything but size gender and bodypart is null");
            return new ResponseEntity<>(closetItemRepository.findBySizeAndGenderAndBodyPart(size, gender, bodyPart), HttpStatus.OK);

        }else if(size == null && selectSeries != null && gender != null && season != null && bodyPart == null) {
            System.out.println("everything but series gender and season is null");
            return new ResponseEntity<>(closetItemRepository.findBySeriesAndGenderAndSeason(selectSeries, gender, season), HttpStatus.OK);

        }else if(size == null && selectSeries != null && gender != null && season == null && bodyPart != null) {
            System.out.println("everything but series gender and bodypart is null");
            return new ResponseEntity<>(closetItemRepository.findBySeriesAndGenderAndBodyPart(selectSeries, gender, bodyPart), HttpStatus.OK);

        }else if(size == null && selectSeries == null && gender != null && season != null && bodyPart != null) {
            System.out.println("everything but gender season and bodypart is null");
            return new ResponseEntity<>(closetItemRepository.findByGenderAndSeasonAndBodyPart(gender, season, bodyPart), HttpStatus.OK);

        }else if(size == null && selectSeries != null && gender != null && season != null && bodyPart != null) {
            System.out.println("series gender season bodypart have value");
            return new ResponseEntity<>(closetItemRepository.findBySeriesAndGenderAndSeasonAndBodyPart(selectSeries, gender, season, bodyPart), HttpStatus.OK);

        }else if(size != null && selectSeries == null && gender != null && season != null && bodyPart != null) {
            System.out.println("size gender season bodypart have value");
            return new ResponseEntity<>(closetItemRepository.findBySizeAndGenderAndSeasonAndBodyPart(size, gender, season, bodyPart), HttpStatus.OK);

        }else if(size != null && selectSeries != null && gender == null && season != null && bodyPart != null) {
            System.out.println("size series season bodypart have value");
            return new ResponseEntity<>(closetItemRepository.findBySizeAndSeriesAndSeasonAndBodyPart(size, selectSeries, season, bodyPart), HttpStatus.OK);

        }else if(size != null && selectSeries != null && gender != null && season == null && bodyPart != null) {
            System.out.println("size series gender bodypart have value");
            return new ResponseEntity<>(closetItemRepository.findBySizeAndSeriesAndGenderAndBodyPart(size, selectSeries, gender, bodyPart), HttpStatus.OK);

        }else if (size !=null && selectSeries != null && gender == null && season == null && bodyPart == null){
            System.out.println("everything but size and series null");
            return new ResponseEntity<>(closetItemRepository.findBySizeAndSeries(size, selectSeries), HttpStatus.OK);
        }
//
        else if (size !=null && selectSeries != null && gender != null && season == null && bodyPart == null){
            System.out.println("size series and gender have value");
            return new ResponseEntity<>(closetItemRepository.findBySizeAndSeriesAndGender(size, selectSeries, gender), HttpStatus.OK);
        }

        else{
            return new ResponseEntity<>(closetItemRepository.findAll(), HttpStatus.BAD_REQUEST);
        }

    }

}
