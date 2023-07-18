package com.ProductListing.ProductListing.api;

import com.ProductListing.ProductListing.model.Image;
import com.ProductListing.ProductListing.model.Product;
import com.ProductListing.ProductListing.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RequestMapping("api/v1/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping(path = "/{id}")
    public Optional<Product> getProductsById(@PathVariable("id") long id){
        return productService.getProductById(id);
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductCreationRequest productCreationRequest){
        Product product = productCreationRequest.getProduct();
        Image image = productCreationRequest.getImage();

        return productService.createProduct(product, image);
    }
    @PutMapping(path = "/{id}")
    public void updateProduct(@PathVariable("id") long id, @RequestBody ProductCreationRequest productCreationRequest){
        Product product = productCreationRequest.getProduct();
        Image image = productCreationRequest.getImage();
        productService.updateProductById(id, product, image);
    }
    @DeleteMapping(path = "/{id}")
    public void deleteProductById(@PathVariable("id") long id){
        productService.deleteProductById(id);
    }

    @PutMapping(path = "/status/{id}")
    public void updateStatusById(@PathVariable("id") long id){
        productService.updateStatusById(id);
    }
}