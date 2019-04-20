package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.GroupService;
import com.kodilla.ecommercee.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    GroupService groupService;

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
        Product productOptional = productService.getProduct(product.getId());

        //Then
        Assert.assertEquals(product.getId(), productOptional.getId());
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
        Long idProduct4 = productService.findByProductName("Product4").get().getId();
        //When
        Product receivedProduct4 = productService.getProduct(idProduct4);
        //Then
        Assert.assertEquals(product4, receivedProduct4);
    }

    @Test
    public void testCreateProduct() {
        //Given
        List<Product> emptyProductList = productService.getAllProducts();
        Product product5 = new Product("Product5", 45.6);
        productService.saveProductOrUpdate(product5);
        Long idProduct5 = productService.findByProductName("Product5").get().getId();
        //When
        List<Product> listCreatedProducts = productService.getAllProducts();
        //Then
        Assert.assertEquals(emptyProductList.size() + 1, listCreatedProducts.size());
    }

    @Test
    public void testUpdateProduct() {
        //Given
        Product product6 = new Product("Product6", 45.8);
        productService.saveProductOrUpdate(product6);
        Long idProduct6 = productService.findByProductName("Product6").get().getId();
        //When
        Product product6Updated = new Product(idProduct6, "Product6 modified", 58.9, null, null);
        productService.saveProductOrUpdate(product6Updated);
        String product6UpdatedName = productService.getProduct(idProduct6).getName();
        //Then
        Assert.assertEquals(product6UpdatedName, "Product6 modified");
    }

    @Test
    public void testDeleteProduct() {
        //Given
        Product product7 = new Product("Product7", 55.4);
        productService.saveProductOrUpdate(product7);
        List<Product> listProducts = productService.getAllProducts();
        Long idProduct7 = productService.findByProductName("Product7").get().getId();
        //When
        productService.deleteProduct(idProduct7);
        List<Product> emptyList = productService.getAllProducts();
        //Then
        Assert.assertEquals(listProducts.size() - 1, emptyList.size());
    }

    @Test
    public void testGetProductsInGroup() {
        //Given
        Group group1 = new Group("Group10");
        groupService.saveGroup(group1);
        Product product8 = new Product("Product8", 55.5);
        Product product9 = new Product("Product9", 65.4);
        group1.getProductsList().add(product8);
        group1.getProductsList().add(product9);
        product8.setGroup(group1);
        productService.saveProductOrUpdate(product8);
        product9.setGroup(group1);
        productService.saveProductOrUpdate(product9);
        List<Product> group1Products = group1.getProductsList();
        //When
        Long idGroup10 = groupService.findByGroupName("Group10").getGroupId();
        List<Product> receivedGroup1Products = productService.getAllProducts().stream()
                .filter(product -> product.getGroup().getGroupId().equals(idGroup10))
                .collect(Collectors.toList());
        //When
        Assert.assertEquals(group1Products.toString(), receivedGroup1Products.toString());
    }

    @Test
    public void testGetProductsInCart() {
        /*//Given
        Product product10 = new Product("Product10", 64.2);
        productService.saveProductOrUpdate(product10);
        Product product11 = new Product("Product11", 72.3);
        productService.saveProductOrUpdate(product11);
        Cart cart10 = new Cart();
        cartService.saveCart(cart10);
        Long idCart10 = cart10.getCartId();
        cart10.getProductsList().add(product10);
        cart10.getProductsList().add(product11);
        product10.setCart(cart10);
        product11.setCart(cart10);
        List<Product> cart10ProductList = cart10.getProductsList();
        //When
        List<Product> readCart10ProductList = productService.getAllProducts().stream()
                .filter(product -> product.getCart().getCartId().equals(idCart10))
                .collect(Collectors.toList());
        //Then
        Assert.assertEquals(cart10ProductList.toString(), readCart10ProductList.toString());*/
    }

    @Test
    public void testMapToProductDto() {
        /*//Given
        Product product11 = new Product(1L, "Product11", 23.4, new Cart(), new Group());
        ProductDto productDto11 = productMapper.mapToProductDto(product11);
        //When
        String mappedProductDto11Name = productDto11.getName();
        //Then
        Assert.assertEquals("Product11", mappedProductDto11Name);*/
    }
}
