package com.code4fun.hackathon.service.impl;

import com.code4fun.hackathon.domain.Image;
import com.code4fun.hackathon.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImageServiceImpl {
    private final ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Transactional
    public void saveImage(byte[] imageData, Long userId) {
        Image imageEntity = new Image();
        imageEntity.setImageData(imageData);
        imageEntity.setUserId(userId);
        imageRepository.save(imageEntity);
    }

    public Image getImageByUserId(Long userId) {
        return imageRepository.findByUserId(userId);
    }
}
