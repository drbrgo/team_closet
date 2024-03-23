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
    public ResponseEntity<?> displayClosetItems (@RequestParam(required = false)String size){
        //intellij shows that sizeFilter is always null; network tab shows that fetch url
        // does have the '?param=xxs' appended if xxs is selected
        //is it because the request param is named sizeFilter here and param on the front end?
        //yes--also needed to change closetitemrepository method findbysize to return an iterable
        //not a single closetitemobject
        if (size == null) {
            System.out.println(size);
            System.out.println(closetItemRepository.findAll());
            return new ResponseEntity<>(closetItemRepository.findAll(), HttpStatus.OK);
        } else {
            System.out.println(size);
            System.out.println(closetItemRepository.findBySize(size));
            return new ResponseEntity<>(closetItemRepository.findBySize(size), HttpStatus.OK);
        }

    }

}
