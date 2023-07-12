package com.ProductListing.ProductListing.service;

import com.ProductListing.ProductListing.model.Image;
import com.ProductListing.ProductListing.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.awt.*;

public interface ImageRepository extends JpaRepository<Image, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Image i SET i.imageName = :imageName, i.imageLink = :imageLink WHERE i.id = :id")
    void updateImageById(long id, String imageName, String imageLink);
}
