package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
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

    @Autowired
    ProductMapper productMapper;

    @Autowired
    CartMapper cartMapper;

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
        /*//Given
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
        Assert.assertEquals(productList.size(), productListRead.size());*/
    }

    @Test
    public void testProductsSizeFromCart() {
        /*//Given
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
        Assert.assertEquals(3, productList.size());*/
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
    @Test
    public void testMapToCartDto() {
        /*//Given
        Cart cart1 = new Cart();
        Product productInCart1 = new Product("Product in cart 1", 55.2);
        //when(cartService.getCart(1L)).thenReturn(cart1);
        cart1.getProductsList().add(productInCart1);
        productInCart1.setCart(cart1);
        String nameProductInCart1 = productInCart1.getName();
        //When
        CartDto cart1Dto = cartMapper.mapToCartDto(cart1);
        int id = cart1.getProductsList().indexOf(productInCart1);
        String nameProductFromMappedCart = cart1Dto.getProductsList().get(id).getName();
        //Then
        Assert.assertEquals(nameProductInCart1, nameProductFromMappedCart);*/
    }

    @Test
    public void testMapToCartDtoList() {
        /*//Given
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Product product1 = new Product("Product11", 20.);
        Product product2 = new Product("Product22", 25.5);
        Product product3 = new Product("Product33", 30.2);
        cart1.getProductsList().add(product1);
        cart2.getProductsList().add(product2);
        cart2.getProductsList().add(product3);
        product1.setCart(cart1);
        product2.setCart(cart2);
        product3.setCart(cart2);
        List<Cart> cartList = new ArrayList<>();
        cartList.add(cart1);
        cartList.add(cart2);
        //When
        List<CartDto> cartDtoList = cartMapper.mapToCartDtoList(cartList);
        //Then
        Assert.assertEquals(cartList.size(), cartDtoList.size());
        Assert.assertEquals(cartList.get(0).getProductsList().get(0).getName(), cartDtoList.get(0).getProductsList().get(0).getName());
        Assert.assertEquals(cartList.get(1).getProductsList().get(0).getName(), cartDtoList.get(1).getProductsList().get(0).getName());
        Assert.assertEquals(cartList.get(1).getProductsList().get(1).getName(), cartDtoList.get(1).getProductsList().get(1).getName());*/
    }

    @Test
    public void testMapToCart() {
        /*CartDto cartDto1 = new CartDto();
        ProductDto productDtoInCart1 = new ProductDto(1L, "Product in cart 1", 36.2, cartDto1.getCartId(), 1L );
        cartDto1.getProductsList().add(productDtoInCart1);
        String nameProductDtoInCart1 = productDtoInCart1.getName();
        //When
        Cart mappedCartDto1 = cartMapper.mapToCart(cartDto1);
        int idProductDtoInCartDto1 = cartDto1.getProductsList().indexOf(productDtoInCart1);
        String nameProductDtoFromMappedCartDto1 = mappedCartDto1.getProductsList().get(idProductDtoInCartDto1).getName();
        //Then
        Assert.assertEquals(nameProductDtoInCart1, nameProductDtoFromMappedCartDto1);*/
    }
}
