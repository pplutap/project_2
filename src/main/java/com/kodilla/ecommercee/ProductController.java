package com.kodilla.ecommercee;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("v1/products")

public class ProductController {

    @GetMapping()
    public ResponseEntity<List<Product>> getProducts(); {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping(value = {productId})
    public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(null);
    }

    @PostMapping(value = "product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("product")
    public ResponseEntity<Void> deleteProduct(Long productId) {
        return ResponseEntity.ok().build();
    }
}
