package com.kodilla.ecommercee.product.controller;

import com.kodilla.ecommercee.product.dto.ProductDto;
import org.springframework.web.bind.annotation.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("ecommercee/product")
public class ProductController {

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam int id) {
        return new ProductDto();
    }

    @PostMapping(value = "addProduct", consumes = APPLICATION_JSON_VALUE)
    public void addProduct(@RequestBody ProductDto productDto) {
        //TODO
        //add final code
    }

    @PutMapping(value = "updateProduct", consumes = APPLICATION_JSON_VALUE)
    public ProductDto editProduct(@RequestBody ProductDto productDto) {
        return new ProductDto();
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam int id) {
        //TODO
        //add final code
    }
}


