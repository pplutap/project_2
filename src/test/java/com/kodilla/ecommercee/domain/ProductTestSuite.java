package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.dto.ProductDto;
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
import java.util.ArrayList;
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
        Product product1 = new Product("apple", 20.0);
        Product product2 = new Product("ham", 40.0);
        Product product3 = new Product("washing machine", 500.50);

        productService.saveProduct(product1);
        productService.saveProduct(product2);
        productService.saveProduct(product3);

        productService.deleteProduct(product1.getId());

        //When
        int size = productService.getAllProducts().size();

        //Then
        Assert.assertEquals(2, size);

    }

    @Test
    public void testSave() {
        Product product1 = new Product("apple", 20.0);
        Product product2 = new Product("ham", 40.0);
        Product product3 = new Product("washing machine", 500.50);

        productService.saveProduct(product1);
        productService.saveProduct(product2);
        productService.saveProduct(product3);

        //When
        int size = productService.getAllProducts().size();

        //Then
        Assert.assertEquals(3, size);
    }

    @Test
    public void testFindAll() {
        //Given
        Product product1 = new Product("apple", 20.0);
        Product product2 = new Product("ham", 40.0);
        Product product3 = new Product("washing machine", 500.50);

        productService.saveProduct(product1);
        productService.saveProduct(product2);
        productService.saveProduct(product3);

        //When
        List<Product> productList = productService.getAllProducts();

        //Then
        Assert.assertEquals(3, productList.size());
    }

    @Test
    public void testFindById() {
        //Given
        Product product1 = new Product("apple", 20.0);
        Product product2 = new Product("ham", 40.0);
        Product product3 = new Product("washing machine", 500.50);

        productService.saveProduct(product1);
        productService.saveProduct(product2);
        productService.saveProduct(product3);

        //When
        Optional<Product> productOptional = productService.getProduct(product1.getId());

        //Then
        Assert.assertEquals(product1.getId(), productOptional.get().getId());
    }

    @Test
    public void testMapProductToProductDto() {
        //Given
        Product product1 = new Product("apple", 20.0);
        Product product2 = new Product("ham", 40.0);
        Product product3 = new Product("washing machine", 500.50);

        productService.saveProduct(product1);
        productService.saveProduct(product2);
        productService.saveProduct(product3);

        //When
        ProductDto productDto = productMapper.mapToProductDto(product1);

        //Then
        Assert.assertEquals(product1.getId(), productDto.getId());
    }

    @Test
    public void testMapToProductDtoList() {
        //Given
        Product product1 = new Product("apple", 20.0);
        Product product2 = new Product("ham", 40.0);
        Product product3 = new Product("washing machine", 500.50);

        //When
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        List<ProductDto> productDtoList = productMapper.mapToProductDtoList(productList);

        //Then
        Assert.assertEquals(3, productDtoList.size());
    }


}
