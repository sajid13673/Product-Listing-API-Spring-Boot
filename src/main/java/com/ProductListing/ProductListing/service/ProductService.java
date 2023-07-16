package com.ProductListing.ProductListing.service;


import com.ProductListing.ProductListing.model.Image;
import com.ProductListing.ProductListing.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;
    @Autowired
    private  ImageRepository imageRepo;

    public ResponseEntity<Product> createProduct(Product product, Image image){
        //Image image1 = imageRepo.save(image);
        //product.setImage(image);
        //repo.save(product);
        //new try
        Product savedProduct = repo.save(product);
        if(!image.getImageName().isBlank()){
            //System.out.println("It's null");
            Image savedImage = imageRepo.save(image);
            long id = savedProduct.getId();
            repo.updateImageIdById(id, savedImage);
            savedProduct.setImage(savedImage);
        }
        return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
    }
    public List<Product> getAllProducts(){
        return repo.findAll();
    }
    public Optional<Product> getProductById(long id){
        return repo.findById(id);
    }
    public void deleteProductById(long id){
        repo.deleteById(id);
    }
    public void updateProductById(long id, Product product, Image image){
        repo.updateById(id, product.getSku(), product.getName(), product.getPrice(), product.getStatus());


        if(!image.getImageName().isBlank()){
            Optional<Product> currentProduct = repo.findById(id);
            Image currentImage = currentProduct.get().getImage();
            if(currentImage == null){
                Image savedImage = imageRepo.save(image);
                repo.updateImageIdById(id, savedImage);
            }
            else{
                String imageName = image.getImageName();
                String imageLink  = image.getImageLink();
                long currentImageId = currentImage.getId();
                imageRepo.updateImageById(currentImageId, imageName, imageLink);
            }
        }
    }
//    public List<Product> getSortedProducts(String sort){
//        return;
//    }

}
