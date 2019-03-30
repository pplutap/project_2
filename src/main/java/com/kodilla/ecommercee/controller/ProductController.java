package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductMapper productMapper;

    @GetMapping("getProducts")
    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(productService.getAllProducts());
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
        return new ProductDto(1L, "Edited Test Product Name", 20.0);
    }

    @DeleteMapping("deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        throw new UnsupportedOperationException("This operation is not yet supported.");
    }
}

