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
@RequestMapping(value = "/closet")
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
            System.out.println("size, series, gender, season and part are null");

            return new ResponseEntity<>(closetItemRepository.findAll(), HttpStatus.OK);

        } else if(selectSeries == null && size != null && gender == null && season == null && bodyPart == null) {
            System.out.println("everything but size is null");
            return new ResponseEntity<>(sizeFilteredClosetItems, HttpStatus.OK);

        } else if(size == null && selectSeries!= null && gender == null && season == null && bodyPart == null) {
            System.out.println("everything but series is null");
            return new ResponseEntity<>(closetItemRepository.findBySeries(selectSeries), HttpStatus.OK);
        }
        else if (size !=null && selectSeries != null && gender == null && season == null && bodyPart == null){
            System.out.println("gender and season and part null");
            return new ResponseEntity<>(closetItemRepository.findBySizeAndSeries(size, selectSeries), HttpStatus.OK);
        }
//
        else if (size !=null && selectSeries != null && gender != null && season == null && bodyPart == null){
            System.out.println("season and part null");
            return new ResponseEntity<>(closetItemRepository.findBySizeAndSeriesAndGender(size, selectSeries, gender), HttpStatus.OK);
        }

        else{
            return new ResponseEntity<>(closetItemRepository.findAll(), HttpStatus.BAD_REQUEST);
        }

    }

}
