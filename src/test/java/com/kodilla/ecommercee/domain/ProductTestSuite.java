package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductTestSuite {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void testFindById(){

        //Given
        Group group = new Group("Test Group");
        groupRepository.save(group);
        Long groupId = group.getGroupId();

        Product product = new Product("Product 1", "Description 1", new BigDecimal("50"), group);
        group.getProductList().add(product);
        productRepository.save(product);
        Long productId = product.getId();

        //When
        Optional<Product> retrievedProduct = productRepository.findById(productId);

        //Then
        assertTrue(retrievedProduct.isPresent());

        //CleanUp
        try{
            groupRepository.deleteById(groupId);
        }catch (Exception e){
            //do nothing
        }

    }


    @Test
    public void testFindAllProducts(){
        //Given
        Group group1 = new Group("Test Group 1");
        groupRepository.save(group1);
        Long group1Id = group1.getGroupId();

        Product product1 = new Product("Product 1", "Description 1", new BigDecimal("100"), group1);
        Product product2 = new Product("Product 2", "Description 2", new BigDecimal("200"), group1);
        group1.getProductList().add(product1);
        group1.getProductList().add(product2);

        Group group2 = new Group("Test Group 2");
        groupRepository.save(group2);
        Long group2Id = group2.getGroupId();

        Product product3 = new Product("Product 3", "Description3", new BigDecimal("300"), group2);
        group2.getProductList().add(product3);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        //When
        List<Product> retrievedProducts = productRepository.findAll();

        //Then
        assertEquals(3, retrievedProducts.size());

        //CleanUp
        try{
            groupRepository.deleteById(group1Id);
            groupRepository.deleteById(group2Id);
        }catch (Exception e) {
            //do nothing
        }
    }



    @Test
    public void testDeleteProduct(){
        //Given
        Group group = new Group("Test Group");
        groupRepository.save(group);
        Long groupId = group.getGroupId();

        Product product = new Product("Product 1", "Description 1", new BigDecimal("100"), group);
        group.getProductList().add(product);
        productRepository.save(product);
        Long productId = product.getId();

        //When
        product.setGroupId(null);
        productRepository.save(product);

        productRepository.deleteById(productId);

        //Then
        assertEquals(0, productRepository.findAll().size());
        assertEquals(1, groupRepository.findAll().size());


        //CleanUp
        try{
            groupRepository.deleteById(groupId);
        }catch (Exception e) {
            //do nothing
        }
    }

}