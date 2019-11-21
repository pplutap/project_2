package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping(value = "/getProducts")
    public List<Product> getProducts() {
        return new ArrayList<>();
    }

    @GetMapping(value = "/getProduct/${id}")
    public Product getProduct(@PathVariable Long id) {
        return null;
    }

    @PostMapping(value = "/createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {

    }

    @PutMapping(value = "/updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }

    @DeleteMapping(value = "/deleteProduct")
    public void deleteProduct(@PathVariable Long id) {

    }
}

//    lista wszystkich produktów
//        pobranie pojedynczego produktu
//        utworzenie produktu
//        aktualizacja danych produktu
//        usunięcie produktu
