package com.kodilla.ecommercee.service;


import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartDbService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public Cart getCartById(Long cartId) throws CartNotFoundException{
        return cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
    }

    public Cart saveCart(final Cart cart) {
        return cartRepository.save(cart);
    }


    public Cart addProductToCart(final Long cartId, final Long productId) throws CartNotFoundException, ProductNotFoundException {
        Cart cartToAddProduct = cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
        cartToAddProduct.getProducts().add(productRepository.findById(productId).orElseThrow(ProductNotFoundException::new));
        return cartRepository.save(cartToAddProduct);
    }

    public Cart deleteProductFromCart(final Long cartId, final Long productId) throws CartNotFoundException, ProductNotFoundException{
        Cart cartToAddProduct = cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
        cartToAddProduct.getProducts().remove(productRepository.findById(productId).orElseThrow(ProductNotFoundException::new));
        return cartRepository.save(cartToAddProduct);
    }
}
