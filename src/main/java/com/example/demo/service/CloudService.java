package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface CloudService {

    String upload(MultipartFile toUpload);
}