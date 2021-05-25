package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDbService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductDbService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProduct(final Long productId) throws ProductNotFoundException{
        return productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
    }
    public Product saveProduct(final Product product){
        return productRepository.save(product);
    }
    public void deleteProduct(final Long productId){
        productRepository.deleteById(productId);
    }
    public List<Product> getProductsByPartOfTheName(String nameParts) {
        return productRepository.findByPartOfTheName(nameParts);
    }
}
