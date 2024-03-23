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
            @RequestParam(required = false)String selectSeries
    ){
        //intellij shows that sizeFilter is always null; network tab shows that fetch url
        // does have the '?param=xxs' appended if xxs is selected
        //is it because the request param is named sizeFilter here and param on the front end?
        //yes--also needed to change closetitemrepository method findbysize to return an iterable
        //not a single closetitemobject

        //trying to circumnavigate findby stacking issues by creating an iterable and then looping through it to find
        //all instances where series=selectSeries -- this doesn't work either... something is up

        Iterable<ClosetItemEntity> sizeFilteredClosetItems = closetItemRepository.findBySize(size);
        ArrayList<ClosetItemEntity> targetClosetItems = new ArrayList<ClosetItemEntity>();


        if (size == null && selectSeries == null) {
            System.out.println(closetItemRepository.findAll());
            return new ResponseEntity<>(closetItemRepository.findAll(), HttpStatus.OK);
        } else if(selectSeries == null) {
            System.out.println(closetItemRepository.findBySize(size));
            return new ResponseEntity<>(sizeFilteredClosetItems, HttpStatus.OK);
        } else if(size ==null) {
            System.out.println(closetItemRepository.findBySeries(selectSeries));
            return new ResponseEntity<>(closetItemRepository.findBySeries(selectSeries), HttpStatus.OK);
        }else {
            System.out.println(size);
            System.out.println(selectSeries);
            System.out.println(closetItemRepository.findBySizeAndSeries(size, selectSeries));
            for(ClosetItemEntity item : sizeFilteredClosetItems) {
                if(item.getSeries().equals(selectSeries)) {
                    targetClosetItems.add(item);
                }
            }
            System.out.println(sizeFilteredClosetItems);
            System.out.println(targetClosetItems);
            return new ResponseEntity<>(targetClosetItems, HttpStatus.OK);
            //return new ResponseEntity<>(closetItemRepository.findBySizeAndSeries(size, series), HttpStatus.OK);
        }

    }

}
