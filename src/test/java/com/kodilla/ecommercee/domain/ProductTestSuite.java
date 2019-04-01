package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.ProductRepository;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTestSuite {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductRepository productRepository;

    @Transactional
    @Test
    public void testDeleteById() {
        //Given
        Cart cart = new Cart();
        Product product1 = new Product(cart, 1L, "apple", 20.0);
        Product product2 = new Product(cart, 1L, "apple", 20.0);
        Product product3 = new Product(cart, 1L, "apple", 20.0);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        //When
        productRepository.deleteById(product1.getId());

        //Then
        Assert.assertEquals(2, productRepository.count());

    }

    @Transactional
    @Test
    public void testSave() {
        //Given
        Cart cart = new Cart();
        Product product1 = new Product(cart, 1L, "apple", 20.0);
        Product product2 = new Product(cart, 1L, "apple", 20.0);
        Product product3 = new Product(cart, 1L, "apple", 20.0);

        //When
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        //Then
        Assert.assertEquals(3, productRepository.count());
    }

    @Transactional
    @Test
    public void testFindAll() {
        //Given
        Cart cart = new Cart();

        Product product1 = new Product(cart, 1L, "apple", 20.0);
        Product product2 = new Product(cart, 1L, "apple", 20.0);
        Product product3 = new Product(cart, 1L, "apple", 20.0);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        //When
        List<Product> productList = productRepository.findAll();

        //Then
        Assert.assertEquals(3, productList.size());
    }

    @Transactional
    @Test
    public void testFindById() {
        //Given
        Cart cart = new Cart();

        Product product1 = new Product(cart, 1L, "apple", 20.0);
        Product product2 = new Product(cart, 1L, "apple", 20.0);
        Product product3 = new Product(cart, 1L, "apple", 20.0);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        //When
        Optional<Product> productOptional = productRepository.findById(product1.getId());

        //Then
        Assert.assertEquals(Optional.of(product1), productOptional);
    }


    @Transactional
    @Test
    public void testMapProductToProductDto() {
        //Given
        Cart cart = new Cart();

        Product product1 = new Product(cart, 1L, "apple", 20.0);
        Product product2 = new Product(cart, 1L, "apple", 20.0);
        Product product3 = new Product(cart, 1L, "apple", 20.0);

        //When
        ProductDto productDto = productMapper.mapToProductDto(product1);

        //Then
        Assert.assertEquals(product1.getId(), productDto.getId());
    }


    @Transactional
    @Test
    public void testMapToProductDtoList() {
        //Given
        Cart cart = new Cart();

        Product product1 = new Product(cart, 1L, "apple", 20.0);
        Product product2 = new Product(cart, 1L, "apple", 20.0);
        Product product3 = new Product(cart, 1L, "apple", 20.0);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

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
