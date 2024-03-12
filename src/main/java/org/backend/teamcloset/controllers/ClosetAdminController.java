package org.backend.teamcloset.controllers;


import org.backend.teamcloset.data.ClosetItemRepository;
import org.backend.teamcloset.models.ClosetItemEntity;
import org.backend.teamcloset.models.dto.ClosetItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping (value = "/admin")
public class ClosetAdminController {

    @Autowired
    ClosetItemRepository closetItemRepository;

    @PostMapping("/addclosetitem")
    public ResponseEntity<?> addClosetItem(@RequestBody ClosetItemDTO closetItemDTO) {
        System.out.println(closetItemDTO);

        ClosetItemEntity newItem = new ClosetItemEntity(closetItemDTO.getModel(), closetItemDTO.getSeries(), closetItemDTO.getSize(), closetItemDTO.getSeason(),
                closetItemDTO.getQuantity(), closetItemDTO.getGender(), closetItemDTO.getBodyPart(), closetItemDTO.getPrice());

        closetItemRepository.save(newItem);

        return new ResponseEntity<>(closetItemRepository.findAll(), HttpStatus.OK);
    }


}
