package com.code4fun.hackathon.repository;

import com.code4fun.hackathon.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findByUserId(Long userId);
}
