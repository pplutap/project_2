package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.ProductGroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTestSuite {

    @Autowired
    private ProductGroupRepository productGroupRepository;
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testProductSaveWithProductGroup() {
        //Given
        ProductGroup productGroup = new ProductGroup();
        Product product1 = new Product("productName1", "description1", new BigDecimal(10), productGroup);
        Product product2 = new Product("productName2", "description2", new BigDecimal(20), productGroup);
        Product product3 = new Product("productName3", "description3", new BigDecimal(30), productGroup);

        product1.setProductGroup(productGroup);
        productGroup.getProductList().add(product1);
        productGroup.getProductList().add(product2);
        productGroup.getProductList().add(product3);
        //When
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productGroupRepository.save(productGroup);

        Long product1Id = product1.getId();
        Long product2Id = product2.getId();
        Long product3Id = product3.getId();
        Long productGroupId = productGroup.getGroupId();
        int productsInGroup = productGroup.getProductList().size();
        //Then
        assertNotEquals(0L, product1Id);
        assertNotEquals(0L, product2Id);
        assertNotEquals(0L, product3Id);
        assertNotEquals(0L, productGroupId);
        assertEquals(3, productsInGroup);
        //CleanUp
        try {
            productRepository.deleteById(product1Id);
            productRepository.deleteById(product2Id);
            productRepository.deleteById(product3Id);
            productGroupRepository.deleteById(productGroupId);
        } catch (Exception e) {
            //do nothing
        }
    }
}

