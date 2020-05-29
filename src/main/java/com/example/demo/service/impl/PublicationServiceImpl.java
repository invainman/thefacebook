package com.example.demo.service.impl;

import com.example.demo.model.Profile;
import com.example.demo.model.Publication;
import com.example.demo.model.dto.CreatePublicationDto;
import com.example.demo.model.dto.UpdatePublicationDto;
import com.example.demo.repository.PublicationRepository;
import com.example.demo.service.CloudService;
import com.example.demo.service.ProfileService;
import com.example.demo.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service


public class PublicationServiceImpl implements PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private CloudService cloudService;

    @Override
    public List<Publication> getAllByProfileId(Long profileId) {
        Profile profile = profileService.getById(profileId);
        return publicationRepository.findAllByAuthor(profile);
    }

    @Override
    public Publication create(CreatePublicationDto createPublicationDto) {
        Publication publication = new Publication();
        publication.setMessage(createPublicationDto.getMessage());
        publication.setImageLink(cloudService.upload(createPublicationDto.getImage()));
        publication.setDate(LocalDateTime.now());
        publication.setAuthor(profileService.getById(createPublicationDto.getProfileId()));
        return publicationRepository.save(publication);
    }

    @Override
    public Publication update(UpdatePublicationDto publicationDto) {
        Publication publication = getById(publicationDto.getId());
        publication.setMessage(publicationDto.getMessage());
        return publicationRepository.save(publication);
    }

    @Override
    public Publication getById(Long id) {
        return publicationRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Publication not found"));
    }

    @Override
    public void deleteById(Long id) {
        publicationRepository.deleteById(id);
    }

}
