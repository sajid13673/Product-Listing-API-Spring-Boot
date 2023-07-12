package com.ProductListing.ProductListing.service;

import com.ProductListing.ProductListing.model.Image;
import com.ProductListing.ProductListing.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.sku = :sku, p.name = :name, p.price = :price, p.status = :status WHERE p.id = :id")
    void updateById(long id, String sku, String name, BigDecimal price, boolean status);
    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.image = :updatedImage WHERE p.id = :id")
    void updateImageIdById(long id, Image updatedImage);
}
//