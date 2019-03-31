package com.kodilla.ecommercee.domain;

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
        Cart cart = new Cart();

        cartService.createEmptyCart(cart);

        //When
        Long id = cart.getCartId();
        Cart readCart = cartService.getCart(id);

        //Then
        Assert.assertEquals(id, readCart.getCartId());
    }

    @Test
    public void testCartFindByAll() {
        //Given
        Cart cart = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();

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
        Cart cart = new Cart();

        Product product = new Product("apple", 20.0);
        Product product2 = new Product("ham", 40.0);
        Product product3 = new Product("washing machine", 500.50);

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);
        productList.add(product3);

        cartService.createEmptyCart(cart);

        Long id = cart.getCartId();

        cartService.getCart(id).getProductsList().add(product);
        cartService.getCart(id).getProductsList().add(product2);
        cartService.getCart(id).getProductsList().add(product3);

        //When
        List<Product> productListRead = cartService.getCart(id).getProductsList();

        //Then
        Assert.assertEquals(productList, productListRead);
    }

    @Test
    public void testProductsSizeFromCart() {
        //Given
        Cart cart = new Cart();

        Product product = new Product("apple", 20.0);
        Product product2 = new Product("ham", 40.0);
        Product product3 = new Product("washing machine", 500.50);

        cartService.createEmptyCart(cart);

        Long id = cart.getCartId();

        cartService.getCart(id).getProductsList().add(product);
        cartService.getCart(id).getProductsList().add(product2);
        cartService.getCart(id).getProductsList().add(product3);

        //When
        List<Product> productList = cartService.getCart(id).getProductsList();

        //Then
        Assert.assertEquals(3, productList.size());
    }

    @Test
    public void testGetAllCarts() {
        //Given
        Cart cart = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();
        Cart cart4 = new Cart();

        cartService.createEmptyCart(cart);
        cartService.createEmptyCart(cart2);
        cartService.createEmptyCart(cart3);
        cartService.createEmptyCart(cart4);

        //When
        List<Cart> cartList = cartService.getAllCarts();

        //Then
        Assert.assertEquals(4, cartList.size());
    }

}
