package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1/product")
public class ProductController {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductService productService;

    @GetMapping("getProducts")
    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(productService.getAllProducts());
    }

    @GetMapping("getProduct")
    public ProductDto getProduct(@RequestParam Long productId) {
        return productMapper.mapToProductDto(productService.getProduct(productId).orElse(null));
    }

    @PostMapping("createProduct")
    public void createProductOrUpdate(@RequestBody ProductDto productDto) {
        productService.saveProductOrUpdate(productMapper.mapToProduct(productDto));
    }

    @DeleteMapping("deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        productService.deleteProduct(productId);
    }
}

