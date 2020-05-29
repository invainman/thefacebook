package com.example.demo.service.impl;

import com.cloudinary.Cloudinary;
import com.example.demo.service.CloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudServiceImpl implements CloudService {

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String upload(MultipartFile toUpload) {
        if (toUpload == null) {
            return "";
        }

        Map uploadResult = Collections.emptyMap();
        try {
            uploadResult = cloudinary.uploader().upload(toUpload.getBytes(), new HashMap<>());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (String) uploadResult.get("url");
    }

    @Bean
    public Cloudinary createCloud() {
        Map<String, String> map = new HashMap<>();
        map.put("cloud_name", "dkgukkgyo");
        map.put("api_key", "791671257415156");
        map.put("api_secret", "2JNCZQH3qoZKljAafzrO7kPZ8b8");

        return new Cloudinary(map);
    }
}
