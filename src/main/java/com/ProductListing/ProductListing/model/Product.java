package com.ProductListing.ProductListing.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Please enter sku")
    @Pattern(regexp = "^[a-zA-Z0-9\\-\\_-]*$", message = "Please enter a valid sku")
    private String sku;
    @NotBlank(message = "Please enter name")
    @Pattern(regexp = "^[a-zA-Z0-9 .\\-\\&()-]*$", message = "Please enter a valid name")
    private String name;
    @NotNull(message = "Please enter price")
    @DecimalMin(value = "0.0", inclusive = false, message = "Please enter a valid message")
    @Digits(integer = 8, fraction = 2, message = "Please enter a valid message")
    private BigDecimal price;
    private boolean status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    public Product(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

//    public Integer getImageId() {
//        return imageId;
//    }
//
//    public void setImageId(Integer imageId) {
//        this.imageId = imageId;
//    }
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}