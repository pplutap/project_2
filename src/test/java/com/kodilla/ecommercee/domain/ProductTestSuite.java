package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTestSuite {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartService cartService;

    @Test
    public void testDeleteById() {
        //Given
        Product product = new Product("apple", 20.0);
        Product product2 = new Product("ham", 40.0);
        Product product3 = new Product("washing machine", 500.50);

        productService.saveProductOrUpdate(product);
        productService.saveProductOrUpdate(product2);
        productService.saveProductOrUpdate(product3);

        productService.deleteProduct(product.getId());

        //When
        int size = productService.getAllProducts().size();

        //Then
        Assert.assertEquals(2, size);

    }

    @Test
    public void testSave() {
        Product product = new Product("apple", 20.0);
        Product product2 = new Product("ham", 40.0);
        Product product3 = new Product("washing machine", 500.50);

        productService.saveProductOrUpdate(product);
        productService.saveProductOrUpdate(product2);
        productService.saveProductOrUpdate(product3);

        //When
        int size = productService.getAllProducts().size();

        //Then
        Assert.assertEquals(3, size);
    }

    @Test
    public void testFindAll() {
        //Given
        Product product = new Product("apple", 20.0);
        Product product2 = new Product("ham", 40.0);
        Product product3 = new Product("washing machine", 500.50);

        productService.saveProductOrUpdate(product);
        productService.saveProductOrUpdate(product2);
        productService.saveProductOrUpdate(product3);

        //When
        List<Product> productList = productService.getAllProducts();

        //Then
        Assert.assertEquals(3, productList.size());
    }

    @Test
    public void testFindById() {
        //Given
        Product product = new Product("apple", 20.0);
        Product product2 = new Product("ham", 40.0);
        Product product3 = new Product("washing machine", 500.50);

        productService.saveProductOrUpdate(product);
        productService.saveProductOrUpdate(product2);
        productService.saveProductOrUpdate(product3);

        //When
        Optional<Product> productOptional = productService.getProduct(product.getId());

        //Then
        Assert.assertEquals(product.getId(), productOptional.get().getId());
    }

}
