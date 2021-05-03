package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    ProductDto sampleProduct = new ProductDto(1L, "kurtka zimowa", "Pellentesque tempus interdum quam ut rhoncus. Donec ullamcorper turpis dolor. Donec euismod pretium eros et eleifend. Aliquam vulputate faucibus lorem non auctor. Vivamus erat turpis, molestie a nisl non, scelerisque luctus enim. Nunc mi mi, laoreet ac mollis nec, pharetra sit amet tortor. Vivamus a bibendum purus.", new BigDecimal(100), "1");

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {

        return Collections.singletonList(sampleProduct);
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(Long productId) {
        return sampleProduct;
    }

    @PostMapping(value = "createProduct")
    public void createProduct(ProductDto productDto) {

    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(ProductDto productDto) {
        return sampleProduct;
    }

    @DeleteMapping(value = "deleteProduct")
        public void deleteProduct(Long productId) {

        }
}
