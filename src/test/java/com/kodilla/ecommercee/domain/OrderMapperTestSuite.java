package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderMapperTestSuite {
    @InjectMocks
    private OrderMapper orderMapper;
    @Mock
    private CartService cartService;
    @Mock
    private UserService userService;

    @Test
    public void testMapToOrderDto() {
        //Given
        Product product1 = new Product("Product1", 25.6);
        Cart cart1 = new Cart();
        Long cart1Id = cart1.getCartId();
        Item item1 = new Item(cart1, product1, 22);
        cart1.getItemsList().add(item1);
        User user1 = new User("User1", false, 1L);
        Long user1Id = user1.getUserId();
        Order order1 = new Order(cart1, user1);
        //When
        OrderDto orderDto = orderMapper.mapToOrderDto(order1);
        //Then
        Assert.assertEquals(cart1Id, orderDto.getCartId());
        Assert.assertEquals(user1Id, orderDto.getUserId());
    }

    @Test
    public void testMapToOrder() {
        //Given
        User user1 = new User("User1", false, 1L);
        OrderDto orderDto = new OrderDto(1L, 2L, 3L);
        when(cartService.getCart(2L)).thenReturn(new Cart());
        when(userService.getUser(3L)).thenReturn(java.util.Optional.ofNullable(user1));
        //When
        Order order = orderMapper.mapToOrder(orderDto);
        //Then
        Assert.assertEquals(user1, order.getUser());
        Assert.assertEquals(user1.getUserName(), order.getUser().getUserName());
    }

    @Test
    public void testMapToOrderDtoList() {
        //Given
        Product product1 = new Product("Product1", 25.6);
        Cart cart1 = new Cart();
        Item item1 = new Item(cart1, product1, 22);
        cart1.getItemsList().add(item1);
        Product product2 = new Product("Product2", 22.0);
        Cart cart2 = new Cart();
        Item item2 = new Item(cart2, product2, 19);
        cart2.getItemsList().add(item2);
        User user1 = new User("User1", false, 1L);
        User user2 = new User("User2", false, 2L);
        Order order1 = new Order(1L, cart1, user1);
        Order order2 = new Order(2L, cart2, user2);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        //When
        List<OrderDto> orderDtoList = orderMapper.mapToOrderDtoList(orderList);
        //Then
        Assert.assertEquals(orderList.size(), orderDtoList.size());
        Assert.assertEquals(user1.getUserId(), orderDtoList.get(0).getUserId());
        Assert.assertEquals(cart1.getCartId(), orderDtoList.get(0).getCartId());
        Assert.assertEquals(user2.getUserId(), orderDtoList.get(1).getUserId());
        Assert.assertEquals(cart2.getCartId(), orderDtoList.get(1).getCartId());
    }
}
