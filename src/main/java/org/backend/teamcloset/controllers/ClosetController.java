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
    public ResponseEntity<?> displayClosetItems (@RequestParam(required = false)String sizeFilter){
        //intellij shows that sizeFilter is always null; network tab shows that fetch url
        // does have the '?param=xxs' appended if xxs is selected
        if (sizeFilter == null) {
            System.out.println(sizeFilter);
            return new ResponseEntity<>(closetItemRepository.findAll(), HttpStatus.OK);
        } else {
            System.out.println(sizeFilter);
            System.out.println(closetItemRepository.findBySize(sizeFilter));
            return new ResponseEntity<>(closetItemRepository.findBySize(sizeFilter), HttpStatus.OK);
        }

    }

}
