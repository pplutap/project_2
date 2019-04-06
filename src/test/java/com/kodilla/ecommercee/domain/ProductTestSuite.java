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

    @Test
    public void testGetAllProducts() {
        //Given
        Product product1 = new Product("Product1", 20.);
        productService.saveProductOrUpdate(product1);
        Product product2 = new Product("Product2", 25.5);
        productService.saveProductOrUpdate(product2);
        Product product3 = new Product("Product3", 30.2);
        productService.saveProductOrUpdate(product3);
        //When
        List<Product> listProducts = productService.getAllProducts();
        //Then
        Assert.assertEquals(3, listProducts.size());
    }

    @Test
    public void testGetProduct() {
        Product product4 = new Product("Product4", 40.3);
        productService.saveProductOrUpdate(product4);
        Long idProduct4 = productService.findByProductName("Product4").getId();
        //When
        Product receivedProduct4 = productService.getProduct(idProduct4).get();
        //Then
        Assert.assertEquals(product4, receivedProduct4);
    }
    @Test
    public void testCreateProduct() {
        //Given
        List<Product> emptyProductList = productService.getAllProducts();
        Product product5 = new Product("Product5" , 45.6);
        productService.saveProductOrUpdate(product5);
        Long idProduct5 = productService.findByProductName("Product5").getId();
        //When
        List<Product> listCreatedProducts = productService.getAllProducts();
        //Then
        Assert.assertEquals(emptyProductList.size()+1, listCreatedProducts.size());
    }

    @Test
    public void testUpdateProduct() {
        //Given
        Product product6 = new Product("Product6", 45.8);
        productService.saveProductOrUpdate(product6);
        Long idProduct6 = productService.findByProductName("Product6").getId();
        //When
        Product product6Updated = new Product(idProduct6, "Product6 modified", 58.9, null, null);
        productService.saveProductOrUpdate(product6Updated);
        String product6UpdatedName = productService.getProduct(idProduct6).get().getName();
        //Then
        Assert.assertEquals(product6UpdatedName, "Product6 modified");
    }

    @Test
    public void testDeleteProduct() {
        //Given
        Product product7 = new Product("Product7", 55.4);
        productService.saveProductOrUpdate(product7);
        List<Product> listProducts = productService.getAllProducts();
        Long idProduct7 = productService.findByProductName("Product7").getId();
        //When
        productService.deleteProduct(idProduct7);
        List<Product> emptyList = productService.getAllProducts();
        //Then
        Assert.assertEquals(listProducts.size()-1, emptyList.size());
    }
}
