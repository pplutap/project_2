package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/ecommercee")
public class CartController {

    @RequestMapping(method = RequestMethod.POST, value = "createCart")
    public void createCart(@RequestParam Long userId) {
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCartsContent")
    public Map<String, Integer> getCart(@RequestParam Long cartId) {
        return new HashMap<String, Integer>();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "addPToCart")
    public void addProduct(@RequestParam Long cartId, @RequestBody String productName, Integer quantity) {
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteFromCart")
    public void deleteProductFromCart(@RequestParam Long cartId, @RequestBody String productName) {
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public TemporaryOrder createOrder(@RequestParam Long cartId) {
        Map<String, Integer> productList = new HashMap<>();
        productList.put("product1", 2);
        productList.put("product2",5);
        return new TemporaryOrder(44256L,122L,productList);
    }
}
