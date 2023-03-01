package com.kodilla.ecommercee;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("v1/products")

public class ProductController {

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getProducts(); {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping(value = {productId})
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(null);
    }

    @PostMapping(value = "product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = {productId})
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        return ResponseEntity.ok().build();
    }
}
