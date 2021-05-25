package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductDbService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    private final ProductMapper productMapper;
    private final ProductDbService productDbService;

    public ProductController(ProductMapper productMapper, ProductDbService productDbService) {
        this.productMapper = productMapper;
        this.productDbService = productDbService;
    }


    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        List<Product> products = productDbService.getAllProducts();
        return productMapper.mapToProductDtoList(products);
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId) throws ProductNotFoundException {
        return productMapper.mapToProductDto(
                productDbService.getProduct(productId)
        );
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "createProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto) throws GroupNotFoundException {
        Product product = productMapper.mapToProduct(productDto);
        productDbService.saveProduct(product);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) throws GroupNotFoundException {
        Product product = productMapper.mapToProduct(productDto);
        Product savedProduct = productDbService.saveProduct(product);
        return productMapper.mapToProductDto(savedProduct);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value = "deleteProduct")
        public void deleteProduct(@RequestParam Long productId){
        productDbService.deleteProduct(productId);
    }

    @GetMapping(value = "getProductsList")
    public List<ProductDto> getProductsList(@RequestParam String nameParts) {
        List<Product> productsList = productDbService.getProductsByPartOfTheName("");
        return productMapper.mapToProductDtoList(productsList);
    }
}
