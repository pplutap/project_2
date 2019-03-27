package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("ecommercee/product")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<Product> getProducts() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public Product getProduct() {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProduct")
    public void addProduct(Product product) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "editProduct")
    public void editProduct(Product product) {

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(Product product) {

    }
}




