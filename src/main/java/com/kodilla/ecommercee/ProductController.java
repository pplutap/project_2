package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping
    public List<ProductDto> getProducts(){

    }

    @GetMapping("{id}")
    public ProductDto getProduct(@PathVariable("id") Long productId) thorws ProductNotFoundException {

    }

    @DeleteMapping("id")
    public void deleteProduct(@PathVariable("id") Long taskId){

    }

    @PutMapping()
    public ProductDto updateTask(@RequestBody ProductDto productDto){

    }

    @PostMapping(consumes = "application/json")
    public void createTask(@RequestBody ProductDto productDto){

    }
}
