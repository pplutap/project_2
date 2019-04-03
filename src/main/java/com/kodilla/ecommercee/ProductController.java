package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping
    public List<String> getProducts(){
        return new ArrayList<>();
    }

    @GetMapping("{id}")
    public String getProduct(@PathVariable("id") Long productId) {
        return "get product";
    }

    @DeleteMapping("id")
    public void deleteProduct(@PathVariable("id") Long productId){

    }

    @PutMapping()
    public String updateProduct(@RequestBody String string){
        return "update product";
    }

    @PostMapping(consumes = "application/json")
    public void createProduct(@RequestBody String string){

    }
}
