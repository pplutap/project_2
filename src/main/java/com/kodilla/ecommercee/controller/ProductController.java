package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("v1/product")
public class ProductController {

    @GetMapping("getProducts")
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @GetMapping("getProduct")
    public ProductDto getProduct(@RequestParam Long productId) {
        return new ProductDto(1L, "Test Product Name", 10.0);
    }

    @PostMapping("createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {
        throw new UnsupportedOperationException("This operation is not yet supported.");
    }

    @PutMapping("updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return new ProductDto(1L, "Test Product Name", 10.0);
    }

    @DeleteMapping("deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        throw new UnsupportedOperationException("This operation is not yet supported.");
    }
}

