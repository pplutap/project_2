package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.domain.ProductNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/v1/carts")
public class CartController {

    @RequestMapping(method = RequestMethod.POST, value = "createCart")
    public void createCart(@RequestBody CartDto cartDto) {
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProductsFromCart")
    public List<ProductDto> getProducts() {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProductToCart")
    public void addProduct(@RequestBody CartDto cartDto) throws ProductNotFoundException {
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "removeProductFromCart")
    public void removeProduct(@RequestBody CartDto cartDto) throws ProductNotFoundException {
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public OrderDto createOrder(@RequestBody OrderDto orderDto, @RequestBody CartDto cartDto) {
        return null;
    }

}

//carts:
//        utworzenie pustego koszyka
//        pobranie elementów z pustego koszyka
//        dodanie elementów (produktów) do koszyka
//        usunięcie konkretnego produktu z koszyka
//        utworzenie zamówienia na podstawie koszyka