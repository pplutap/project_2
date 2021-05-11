package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartTestSuite {

    @Autowired
    private CartRepository cartRepository;


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
        Cart cart = new Cart();
        //When
        cartRepository.save(cart);
        Long idCard = cart.getCartId();
        cartRepository.deleteById(idCard);
        //Then
        assertTrue(cartRepository.findAll().isEmpty());
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
