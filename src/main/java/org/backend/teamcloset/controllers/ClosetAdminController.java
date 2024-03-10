package org.backend.teamcloset.controllers;


import jakarta.transaction.Transactional;
import org.backend.teamcloset.data.ClosetItemRepository;
import org.backend.teamcloset.data.ModelRepository;
import org.backend.teamcloset.models.ClosetItemEntity;
import org.backend.teamcloset.models.ModelEntity;
import org.backend.teamcloset.models.dto.ClosetItemDTO;
import org.backend.teamcloset.models.dto.ModelDTO;
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
    @Autowired
    ModelRepository modelRepository;

    @PostMapping("/addclosetitem")
    public ResponseEntity<?> addClosetItem(@RequestBody ClosetItemDTO closetItemDTO) {
        System.out.println(closetItemDTO);

        ClosetItemEntity newItem = new ClosetItemEntity(closetItemDTO.getModel(), closetItemDTO.getSeries(), closetItemDTO.getSize(), closetItemDTO.getSeason(),
                closetItemDTO.getQuantity(), closetItemDTO.getGender(), closetItemDTO.getBodyPart(), closetItemDTO.getPrice());

        closetItemRepository.save(newItem);

        return new ResponseEntity<>(closetItemRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addmodel")
    public ResponseEntity<?> addModel(@RequestBody ModelDTO modelDTO) {

        ModelEntity newModel = new ModelEntity(modelDTO.getModelName());

        modelRepository.save(newModel);

        return new ResponseEntity<>(modelDTO, HttpStatus.OK);
    }

    @GetMapping("/getmodels")
    public ResponseEntity<?> getModels() {
        return new ResponseEntity<>(modelRepository.findAll(), HttpStatus.OK);
    }
}
