package com.code4fun.hackathon.controllers;

import com.code4fun.hackathon.domain.Image;
import com.code4fun.hackathon.repository.ImageRepository;
import com.code4fun.hackathon.service.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping()
public class ImageController {

    private final ImageServiceImpl imageService;

    @Autowired
    public ImageController(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }


    @PostMapping("/upload/image")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile image,
                                              @RequestParam("userId") Long userId) {
        try {
            byte[] imageData = image.getBytes();
            imageService.saveImage(imageData, userId);
            return ResponseEntity.ok("Image uploaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload the image.");
        }
    }

    @GetMapping("/upload/image/{userId}")
    public ResponseEntity<byte[]> getImagesByUserId(@PathVariable Long userId) {
        Image images = imageService.getImageByUserId(userId);
        if (images != null) {
            return ResponseEntity.ok(images.getImageData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}





