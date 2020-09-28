package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts() {
        List<ProductDto> listOfProducts = new ArrayList<>();
        listOfProducts.add(new ProductDto(1L, "product1", "description1", new BigDecimal("12.3")));
        listOfProducts.add(new ProductDto(2L, "product2", "description2", new BigDecimal("23.4")));
        return listOfProducts;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public ProductDto getProduct(@RequestParam final Long id) throws ProductNotFoundException {
        if (id == 1) {
            return new ProductDto(1L, "product1", "description1", new BigDecimal("12.1"));
        } else {
            throw new ProductNotFoundException();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct")
    public String createProduct(@RequestBody ProductDto productDto) {
        if (productDto.getId() == 1 &&
                productDto.getName().equals("product1") &&
                productDto.getDescription().equals("description1") &&
                productDto.getPrice().equals(new BigDecimal("12.3"))) {
            return "Product created";
        } else {
            return "Wrong body parameters";
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public String deleteProduct(@RequestParam final Long id) throws ProductNotFoundException {
        if (id == 1) {
            return "Product deleted";
        } else {
            return "Wrong parameters";
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public String updateProduct(@RequestBody ProductDto productDto) {
        if (productDto.getId() == 1 &&
                productDto.getName().equals("product1") &&
                productDto.getDescription().equals("description1") &&
                productDto.getPrice().equals(new BigDecimal("12.3"))) {
            return "Product updated";
        } else {
            return "Wrong product parameters";
        }
    }
}

