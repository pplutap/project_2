package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("carts")

public class CartController {

    @RequestMapping( method = RequestMethod.GET, value = "getProductsFromCart")
    public String getProductsFromCart(@RequestParam Long cartID) {

        return "cloth , paper";
    }

    @RequestMapping(method = RequestMethod.PUT,value = "addProductToCart")
    public String addProductToCart() {

        return "producr added";
    }

    @RequestMapping(method = RequestMethod.POST, value = "createEmptyCart")
    public String createEmptyCart() {

        return "cart created";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProductFromCart")
    public String deleteProductFromCart() {

        return "product removed";
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrderFromCart")
    public String createOrderFromCart() {

        return "order created";
    }

}


