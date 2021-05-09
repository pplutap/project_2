package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductDbService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    private final ProductMapper productMapper;
    private final ProductDbService productDbService;
    ProductDto sampleProduct = new ProductDto(1L, "kurtka zimowa", "Pellentesque tempus interdum quam ut rhoncus. Donec ullamcorper turpis dolor. Donec euismod pretium eros et eleifend. Aliquam vulputate faucibus lorem non auctor. Vivamus erat turpis, molestie a nisl non, scelerisque luctus enim. Nunc mi mi, laoreet ac mollis nec, pharetra sit amet tortor. Vivamus a bibendum purus.", new BigDecimal(100), new Group());

    public ProductController(ProductMapper productMapper, ProductDbService productDbService) {
        this.productMapper = productMapper;
        this.productDbService = productDbService;
    }


    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        List<Product> products = productDbService.getAllProducts();
        return productMapper.mapToProductDtoList(products);
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId) throws ProductNotFoundException {
        return productMapper.mapToProductDto(
                productDbService.getProduct(productId).orElseThrow(ProductNotFoundException::new)
        );
    }

    @PostMapping(value = "createProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        productDbService.saveProduct(product);
    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        Product savedProduct = productDbService.saveProduct(product);
        return productMapper.mapToProductDto(savedProduct);
    }

    @DeleteMapping(value = "deleteProduct")
        public void deleteProduct(@RequestParam Long productId){
        productDbService.deleteProduct(productId);
        }
}
