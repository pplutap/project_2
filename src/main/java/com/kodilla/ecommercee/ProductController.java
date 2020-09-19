package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public String getProducts() {
        return "List of products";
    }
    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public String getProduct() {
        return "Product";
    }
    @RequestMapping(method = RequestMethod.POST, value = "createProduct")
    public String createProduct() {
        return "Product created";
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public String deleteProduct() {
        return "Product deleted";
    }
    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public String updateProduct() {
        return "Product updated";
    }
}
