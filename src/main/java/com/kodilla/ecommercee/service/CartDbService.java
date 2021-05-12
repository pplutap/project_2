package com.kodilla.ecommercee.service;


import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartDbService {

    private final CartRepository cartRepository;

    public Cart getOriginalCart(Long id) throws CartNotFoundException{
        return cartRepository.findById(id).orElseThrow(CartNotFoundException::new);
    }
}
