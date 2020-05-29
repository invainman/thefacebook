package com.example.demo.model.dto;


import org.springframework.web.multipart.MultipartFile;

public class CreatePublicationDto {
    private String message;

    private MultipartFile image;

    private Long profileId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}
