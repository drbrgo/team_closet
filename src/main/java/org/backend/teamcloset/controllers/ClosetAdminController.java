package org.backend.teamcloset.controllers;


import org.backend.teamcloset.data.ClosetItemRepository;
import org.backend.teamcloset.models.ClosetItemEntity;
import org.backend.teamcloset.models.dto.ClosetItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping (value = "/admin")
public class ClosetAdminController {

    @Autowired
    ClosetItemRepository closetItemRepository;

    @PostMapping("/addclosetitem")
    public ResponseEntity<?> addClosetItem(@RequestBody ClosetItemDTO closetItemDTO) {
        System.out.println(closetItemDTO);

        // make closetItemRepository.findAll an iterable list
        List<ClosetItemEntity> closetItems = closetItemRepository.findAll();


        //assign a value to response
        ResponseEntity response = new ResponseEntity<>(closetItemRepository.findAll(), HttpStatus.OK);

        //loop thru closetItemRepo and check if model/size/series combo already exists
        for (ClosetItemEntity closetItem : closetItems) {
            System.out.println(closetItem.getModel().toUpperCase());
            if (closetItem.getModel().equalsIgnoreCase(closetItemDTO.getModel()) &&
                    closetItem.getSeries().equalsIgnoreCase(closetItemDTO.getSeries()) &&
                    closetItem.getSize().equalsIgnoreCase(closetItemDTO.getSize()) &&
                    closetItem.getGender().equalsIgnoreCase(closetItemDTO.getGender())) {
                System.out.println("conflict!");
                response = new ResponseEntity<>(closetItem, HttpStatus.CONFLICT);
                return response;
            }

        }

        //otherwise save new item in closet item repo and return 200 code
        ClosetItemEntity newItem = new ClosetItemEntity(closetItemDTO.getModel(), closetItemDTO.getSeries(), closetItemDTO.getSize(), closetItemDTO.getSeason(),
                closetItemDTO.getQuantity(), closetItemDTO.getGender(), closetItemDTO.getBodyPart(), closetItemDTO.getPrice());

        closetItemRepository.save(newItem);

        return response;

    }

}






