package com.example.demo.controller;

import com.example.demo.model.Publication;
import com.example.demo.model.dto.CreatePublicationDto;
import com.example.demo.model.dto.UpdatePublicationDto;
import com.example.demo.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/publication")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @PostMapping
    public Publication create(@RequestParam("message") String message, @RequestParam("profileId") Long profileId, @RequestParam("image") MultipartFile image) {
        CreatePublicationDto dto = new CreatePublicationDto();
        dto.setImage(image);
        dto.setMessage(message);
        dto.setProfileId(profileId);

        return publicationService.create(dto);
    }

    @PutMapping
    public Publication update(@RequestBody UpdatePublicationDto publication) {
        return publicationService.update(publication);
    }

    @GetMapping
    public Publication getById(@RequestParam Long id) {
        return publicationService.getById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        publicationService.deleteById(id);
    }

    @GetMapping(value = "/all")
    public List<Publication> getAll(@RequestParam Long profileId) {
        return publicationService.getAllByProfileId(profileId);
    }
}
