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
        return null;
    }

    @DeleteMapping("id")
    public void deleteProduct(@PathVariable("id") Long productId){

    }

    @PutMapping()
    public String updateTask(@RequestBody String string){
        return null;
    }

    @PostMapping(consumes = "application/json")
    public void createTask(@RequestBody String string){

    }
}
