package com.kodilla.ecommercee.cart;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.service.CartService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuite {

    @Autowired
    private CartService cartService;

    @Test
    public void testCartSave() {
        //Given
        Cart cart = new Cart(1L);

        cartService.createEmptyCart(cart);

        //When
        Long id = cart.getCartId();
        Cart readCart = cartService.getCart(1L);

        //Then
        Assert.assertEquals(id, readCart.getCartId());
    }

    @Test
    public void testCartFindByAll() {
        //Given
        Cart cart = new Cart(1L);
        Cart cart2 = new Cart(2L);
        Cart cart3 = new Cart(3L);

        cartService.createEmptyCart(cart);
        cartService.createEmptyCart(cart2);
        cartService.createEmptyCart(cart3);

        //When
        List<Cart> cartList = cartService.getAllCarts();

        //Then
        Assert.assertEquals(3, cartList.size());
    }

    @Test
    public void testProductsFromCart() {
        //Given
        Cart cart = new Cart(1L);
        Long id = cart.getCartId();

        Product product = new Product(1L, "Apple", 20.0);
        Product product2 = new Product(2L, "Ham", 20.0);
        Product product3 = new Product(3L, "Peach", 5.0);

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);
        productList.add(product3);

        cartService.createEmptyCart(cart);

        cartService.getProductsFromCart(id).add(product);
        cartService.getProductsFromCart(id).add(product2);
        cartService.getProductsFromCart(id).add(product3);

        //When
        List<Product> productListRead = cartService.getProductsFromCart(1L);

        //Then
        Assert.assertEquals(productList, productListRead);
    }

    @Test
    public void testProductsSizeFromCart() {
        //Given
        Cart cart = new Cart(1L);
        Long id = cart.getCartId();

        Product product = new Product(1L, "Apple", 20.0);
        Product product2 = new Product(2L, "Ham", 20.0);
        Product product3 = new Product(3L, "Peach", 5.0);

        cartService.createEmptyCart(cart);

        cartService.getProductsFromCart(id).add(product);
        cartService.getProductsFromCart(id).add(product2);
        cartService.getProductsFromCart(id).add(product3);

        //When
        List<Product> productList = cartService.getProductsFromCart(1L);

        //Then
        Assert.assertEquals(3, productList.size());
    }

}
