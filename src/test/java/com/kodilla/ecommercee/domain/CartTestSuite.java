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

        cartService.saveCart(cart);

        //When
        Cart readCart = cartService.getCart(cart.getCartId());

        //Then
        Assert.assertEquals(cart, readCart);
    }

    @Test
    public void testCartFindByAll() {
        //Given
        Cart cart = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();

        cartService.saveCart(cart);
        cartService.saveCart(cart2);
        cartService.saveCart(cart3);

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

        cartService.saveCart(cart);

        Long id = cart.getCartId();

        cartService.getCart(id).getProductsList().add(product);
        cartService.getCart(id).getProductsList().add(product2);
        cartService.getCart(id).getProductsList().add(product3);

        cartService.saveCart(cart);

        //When
        List<Product> productListRead = cartService.getCart(id).getProductsList();

        //Then
        Assert.assertEquals(productList.size(), productListRead.size());
    }

    @Test
    public void testProductsSizeFromCart() {
        //Given
        Cart cart = new Cart();

        Product product = new Product("apple", 20.0);
        Product product2 = new Product("ham", 40.0);
        Product product3 = new Product("washing machine", 500.50);

        cartService.saveCart(cart);

        Long id = cart.getCartId();

        cartService.getCart(id).getProductsList().add(product);
        cartService.getCart(id).getProductsList().add(product2);
        cartService.getCart(id).getProductsList().add(product3);

        cartService.saveCart(cartService.getCart(id));

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

        cartService.saveCart(cart);
        cartService.saveCart(cart2);
        cartService.saveCart(cart3);
        cartService.saveCart(cart4);

        //When
        List<Cart> cartList = cartService.getAllCarts();

        //Then
        Assert.assertEquals(4, cartList.size());
    }

}
