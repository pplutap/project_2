package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dao.ProductDao;
import com.kodilla.ecommercee.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTests {
    @Autowired
    private ProductDao productDao;

    @Test
    public void ProductDaoSaveTestSuite() {
        //Given
        Product product = new Product("product1", 12.5);
        //When
        productDao.save(product);
        Long produtId = product.getId();
        //Then
        assertEquals("product1", productDao.findById(produtId).get().getName());
        assertEquals(12.5, productDao.findById(produtId).get().getPrize(), 0.001);

        //Clean Up
        productDao.deleteById(produtId);
    }

    @Test
    public void ProductDaoFindAllTestSuite(){
        //Given
        Product product1 = new Product("product1", 11.5);
        Product product2 = new Product("product2", 12.5);
        Product product3 = new Product("product3", 13.5);

        //When
        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        List<Product> productList = productDao.findAll();
        Long produtId1 = product1.getId();
        Long produtId2 = product2.getId();
        Long produtId3 = product3.getId();

        //Then
        assertEquals(3, productDao.findAll().size());
        assertEquals("product1", productDao.findById(produtId1).get().getName());
        assertEquals(11.5, productDao.findById(produtId1).get().getPrize(), 0.001);
        assertEquals("product2", productDao.findById(produtId2).get().getName());
        assertEquals(12.5, productDao.findById(produtId2).get().getPrize(), 0.001);
        assertEquals("product3", productDao.findById(produtId3).get().getName());
        assertEquals(13.5, productDao.findById(produtId3).get().getPrize(), 0.001);

        //Clean Up
        productDao.deleteById(produtId1);
        productDao.deleteById(produtId2);
        productDao.deleteById(produtId3);
    }

    @Test
    public void ProductDaoFindByIdTestSuite(){
        //Given
        Product product1 = new Product("product1", 11.5);
        Product product2 = new Product("product2", 12.5);
        Product product3 = new Product("product3", 13.5);

        //When
        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        List<Product> productList = productDao.findAll();
        Long produtId1 = product1.getId();
        Long produtId2 = product2.getId();
        Long produtId3 = product3.getId();

        //Then
        assertEquals(3, productDao.findAll().size());
        assertEquals("product1", productDao.findById(produtId1).get().getName());
        assertEquals(11.5, productDao.findById(produtId1).get().getPrize(), 0.001);

        //Clean Up
        productDao.deleteById(produtId1);
        productDao.deleteById(produtId2);
        productDao.deleteById(produtId3);
    }

    @Test
    public void ProductDaoDeleteByIdTestSuite(){
        //Given
        Product product1 = new Product("product1", 11.5);
        Product product2 = new Product("product2", 12.5);
        Product product3 = new Product("product3", 13.5);

        //When
        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        List<Product> productList = productDao.findAll();
        Long produtId1 = product1.getId();
        Long produtId2 = product2.getId();
        Long produtId3 = product3.getId();

        //Then
        assertEquals(3, productDao.findAll().size());
        productDao.deleteById(produtId3);
        assertEquals(2, productDao.findAll().size());
        productDao.deleteById(produtId2);
        assertEquals(1, productDao.findAll().size());
        productDao.deleteById(produtId1);
        assertEquals(0, productDao.findAll().size());
    }
}
