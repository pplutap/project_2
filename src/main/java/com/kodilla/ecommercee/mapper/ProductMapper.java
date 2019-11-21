package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescroption(),
                product.getPrice()
        );
        return productDto;
    }

    public Product mapToProduct(ProductDto productDto) {
        Product product = new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescroption(),
                productDto.getPrice()
        );
        return product;
    }

    public List<ProductDto> mapToProductDtoList(List<Product> products) {
        return products.stream()
                .map(product -> new ProductDto(product.getId(), product.getName(), product.getDescroption(), product.getPrice()))
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(List<ProductDto> dtoProducts) {
        return dtoProducts.stream()
                .map(product -> new Product(product.getId(), product.getName(), product.getDescroption(), product.getPrice()))
                .collect(Collectors.toList());
    }
}
