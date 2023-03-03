package com.kodilla.ecommercee;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/carts")
public class CartController {

    @PostMapping(value = "createCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCart(@RequestBody CartDto cartDto){
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CartDto>> getItemsFromCart(){
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "{itemId}")
    public ResponseEntity<CartDto> addItemToCart(@PathVariable Long itemId){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "{itemId}")
    public ResponseEntity<Void> deleteElement(@PathVariable Long itemId) {
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Void> createOrder(){
            return ResponseEntity.ok().build();
        }
}
