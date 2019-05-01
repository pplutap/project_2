package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.GroupService;
import com.kodilla.ecommercee.service.ItemService;
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

    @Autowired
    ItemService itemService;

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
        Product product5 = new Product("Product5" , 45.6);
        productService.saveProductOrUpdate(product5);
        Long idProduct5 = productService.findByProductName("Product5").get().getId();
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
        Assert.assertEquals(listProducts.size()-1, emptyList.size());
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
    public void testMapToProductDto() {
        //Given
        List<Item> items = new ArrayList<>();
        Product product11 = new Product(1L, "Product11", 23.4, new Group(), items);
        ProductDto productDto11 = productMapper.mapToProductDto(product11);
        //When
        String mappedProductDto11Name = productDto11.getName();
        //Then
        Assert.assertEquals("Product11", mappedProductDto11Name);
    }

    @Test
    public void testMapDtoToProduct() {
        //Given
        List<Long> items = new ArrayList<>();
        ProductDto productDto11 = new ProductDto(1L, "Product11", 23.4, 1L, items);
        Product product11 = productMapper.mapToProduct(productDto11);
        //When
        String mappedProductDto11Name = product11.getName();
        //Then
        Assert.assertEquals("Product11", mappedProductDto11Name);
    }

    @Test
    public void testMapListProductToDtoListProduct() {
        //Given
        List<Item> items = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        Product product11 = new Product(1L, "Product11", 23.4, new Group(), items);
        Product product12 = new Product(2L, "Product12", 23.4, new Group(), items);
        Product product13 = new Product(3L, "Product13", 23.4, new Group(), items);

        productList.add(product11);
        productList.add(product12);
        productList.add(product13);

        //When
        List<ProductDto> productDtoListMapper = productMapper.mapToProductDtoList(productList);

        //Then
        Assert.assertEquals(productList.size(), productDtoListMapper.size());
    }

    @Test
    public void testMapListProductDtoListToProductList() {
        //Given
        List<Long> items = new ArrayList<>();
        List<ProductDto> productDtoList = new ArrayList<>();
        ProductDto product11 = new ProductDto(1L, "Product11", 23.4, 1L, items);
        ProductDto product12 = new ProductDto(2L, "Product12", 50.0, 1L, items);
        ProductDto product13 = new ProductDto(3L, "Product13", 60.0, 1L, items);

        productDtoList.add(product11);
        productDtoList.add(product12);
        productDtoList.add(product13);

        //When
        List<Product> productListMapper = productMapper.mapToProductList(productDtoList);

        //Then
        Assert.assertEquals(productDtoList.size(), productListMapper.size());
    }

}
