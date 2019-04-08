package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @GetMapping
    public List<ProductDto> getProducts(){
        System.out.println("Return all products");
        return new ArrayList<>();
    }

    @GetMapping("{id}")
    public ProductDto getProduct(@PathVariable("id") Long productId) {
        System.out.println("Return one product");
        return new ProductDto();
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Long productId){
        System.out.println("Product is deleted");
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto){
        System.out.println("Product updated");
        return new ProductDto();
    }

    @PostMapping
    public void createProduct(@RequestBody ProductDto productDto){
        System.out.println("Product is created");
    }
}
