package com.ProductListing.ProductListing.api;

import com.ProductListing.ProductListing.model.Image;
import com.ProductListing.ProductListing.model.Product;
import com.ProductListing.ProductListing.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RequestMapping("api/v1/product")
@RestController
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

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
//        ResponseEntity<Product> h = new ResponseEntity<Product>(product, HttpStatus.CREATED);
//        System.out.println(h);
//        return h;
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

    @GetMapping(path = "/sort")
    public void getSortedProducts(@RequestBody Object obj){
        // sort1 = obj.toA
        System.out.println("Sorted Products by: "+obj);
    }
}