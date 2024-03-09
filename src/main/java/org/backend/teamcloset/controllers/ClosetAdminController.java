package org.backend.teamcloset.controllers;


import org.backend.teamcloset.models.dto.ClosetItemDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping (value = "/admin")
public class ClosetAdminController {

    @PostMapping("/addclosetitem")
    public ResponseEntity<?> addClosetItem(@RequestBody ClosetItemDTO closetItemDTO) {
        System.out.println(closetItemDTO);
        return new ResponseEntity<>(closetItemDTO, HttpStatus.OK);
    }
}
