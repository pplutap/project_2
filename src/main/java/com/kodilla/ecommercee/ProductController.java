package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee")
public class ProductController {
    @RequestMapping(method = RequestMethod.GET, value = "products")
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "products/{productId}")
    public ProductDto getProduct(@PathVariable Long productId) {
        return new ProductDto(1L, "name", "test description", new BigDecimal("10.0"), 1L);
    }

    @RequestMapping(method = RequestMethod.POST, value = "products")
    public void createProduct(ProductDto productDto) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "products/{productId}")
    public ProductDto updateProduct(@PathVariable Long productId, ProductDto productDto) {
        return new ProductDto(1L, "edited name", "test description", new BigDecimal("20.0"), 1L);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "products/{productId}")
    public void deleteProduct(@PathVariable Long productId) {

    }
}
