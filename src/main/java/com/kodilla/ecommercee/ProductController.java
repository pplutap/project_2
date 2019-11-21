package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.domain.ProductNotFoundException;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/getProducts")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(value = "/getProduct/${productId}")
    public Product getProduct(@PathVariable Long productId) throws ProductNotFoundException {
        return productService.getProductById(productId).orElseThrow(ProductNotFoundException::new);
    }

    @PostMapping(value = "/createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
    }

    @PutMapping(value = "/updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) throws ProductNotFoundException {
        return productService.updateProduct(productDto);
    }

    @DeleteMapping(value = "/deleteProduct/${productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProductById(productId);
    }
}
