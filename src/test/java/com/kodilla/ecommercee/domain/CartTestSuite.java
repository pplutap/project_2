package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartTestSuite {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;



    @Test
    public void testSaveCart(){
        //Given
        Cart cart = new Cart();
        //When
        cartRepository.save(cart);
        Long idCard = cart.getCartId();
        //Then
        assertNotEquals(0L, idCard);
        //CleanUp
        cartRepository.deleteById(idCard);
    }
    @Test
    public void testDeleteByIdCart(){
        //Given
        List<Product> products = new ArrayList<>();
        List<Cart> carts = new ArrayList<>();

        Cart cart1 = new Cart();
        carts.add(cart1);

        Product product1 = new Product();

        product1.setName("kurtka zimowa");
        product1.setPrice(new BigDecimal(150));
        product1.setDescription("long");
        products.add(product1);
        cart1.setProducts(products);
        product1.setCarts(carts);
        productRepository.save(product1);

        //When
        cartRepository.save(cart1);
        Long cart1Id = cart1.getCartId();
        Long product1Id = product1.getId();


        //Then
        assertTrue(carts.size() == 1);
        assertTrue(cartRepository.existsById(cart1Id));

        //CleanUp
        cartRepository.deleteById(cart1Id);
        assertFalse(cartRepository.existsById(cart1Id));
        assertTrue(productRepository.existsById(product1Id));
        productRepository.deleteAll();


    }
    @Test
    public void testCartAndProductRelations() {
        //Given
        List<Product> products = new ArrayList<>();
        List<Cart> carts = new ArrayList<>();

        Cart cart1 = new Cart();
        carts.add(cart1);

        Product product1 = new Product();

        product1.setName("kurtka zimowa");
        product1.setPrice(new BigDecimal(150));
        product1.setDescription("long");
        products.add(product1);

        product1.setCarts(carts);
        productRepository.save(product1);
        cart1.setProducts(products);

        //When
        cartRepository.save(cart1);
        Long cart1Id = cart1.getCartId();
        Long product1Id = product1.getId();

        String productName = product1.getName();
        String productNameInCart = cart1.getProducts().get(products.size() - 1).getName();

        //Then
        assertEquals(productName, productNameInCart);

        //CleanUp
        cartRepository.deleteById(cart1Id);
        productRepository.deleteAll();
    }

    @Test
    public void testFindAllCarts(){
        //Given
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();
        //When
        cartRepository.save(cart1);
        Long idCart1 = cart1.getCartId();
        cartRepository.save(cart2);
        Long idCart2 = cart2.getCartId();
        cartRepository.save(cart3);
        Long idCart3 = cart3.getCartId();
        //Then
        assertEquals(3, cartRepository.findAll().size());
        //CleanUp
        cartRepository.deleteById(idCart2);
        cartRepository.deleteById(idCart3);
        cartRepository.deleteById(idCart1);

    }
}
