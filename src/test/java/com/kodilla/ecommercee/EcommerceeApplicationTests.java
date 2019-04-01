package com.kodilla.ecommercee;

import com.kodilla.ecommercee.cart.domain.Cart;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EcommerceeApplicationTests {

    @Test
    public void testIfCartIdIsNull() {
        //Given
        Cart cart = new Cart();
        //When
        Long cartId = cart.getCartId();
        //Then
        Assert.assertEquals(null, cartId);
    }

}

