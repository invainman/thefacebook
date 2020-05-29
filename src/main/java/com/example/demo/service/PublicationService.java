package com.example.demo.service;

import com.example.demo.model.Publication;
import com.example.demo.model.dto.CreatePublicationDto;
import com.example.demo.model.dto.UpdatePublicationDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PublicationService {

    List<Publication> getAllByProfileId(Long profileId);

    Publication create(CreatePublicationDto publication);

    Publication update(UpdatePublicationDto publication);

    Publication getById(Long id) throws RuntimeException;

    void deleteById(Long id);
}
