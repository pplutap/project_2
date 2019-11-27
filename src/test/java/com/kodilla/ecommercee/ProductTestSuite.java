package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.domain.ProductNotFoundException;
import com.kodilla.ecommercee.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductTestSuite {

    @Autowired
    private ProductService productService;

    @Test
    public void addProductTest() throws ProductNotFoundException {
        //Given
        ProductDto product = new ProductDto();
        product.setName("Test");
        product.setDescription("Testowy produkt");
        product.setPrice(500);

        //When
        productService.saveProduct(product);

        //Then
        Assert.assertEquals(1, productService.getProducts().size());
        Assert.assertEquals("Test", productService.getProductById(1L).getName());
    }

    @Test
    public void deleteProductTest() throws ProductNotFoundException {
        //Given
        ProductDto product = new ProductDto();
        product.setName("Test");
        product.setDescription("Testowy produkt");
        product.setPrice(500);

        ProductDto product2 = new ProductDto();
        product2.setName("Test");
        product2.setDescription("Testowy produkt");
        product2.setPrice(500);

        //When
        productService.saveProduct(product);
        productService.saveProduct(product2);
        productService.deleteProductById(2L);

        //Then
        Assert.assertEquals(1, productService.getProducts().size());
    }
}
