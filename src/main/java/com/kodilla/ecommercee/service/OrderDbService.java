package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDbService {

    private final OrderRepository orderRepository;
}
