package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
@CrossOrigin("*")
public class OrderController {

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getOrders() { return ResponseEntity.ok(Collections.emptyList()); }

    @GetMapping(value = "{orderId}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long orderId) { return ResponseEntity.ok(null); }

    @DeleteMapping(value = "{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) { return ResponseEntity.ok(null); }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(null);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok().build();
    }
}
