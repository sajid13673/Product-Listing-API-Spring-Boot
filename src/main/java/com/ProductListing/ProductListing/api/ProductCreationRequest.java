package com.ProductListing.ProductListing.api;

import com.ProductListing.ProductListing.model.Image;
import com.ProductListing.ProductListing.model.Product;

public class ProductCreationRequest {
    private Product product;
    private Image image;

    public ProductCreationRequest(Product product, Image image) {
        this.product = product;
        this.image = image;
    }

    public Product getProduct() {
        return product;
    }

    public Image getImage() {
        return image;
    }
}
