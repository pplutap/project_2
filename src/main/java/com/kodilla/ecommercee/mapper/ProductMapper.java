package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public Product mapToProduct(final ProductDto productDto) {
        return new Product(productDto.getCart(), productDto.getId(),
                productDto.getName(),
                productDto.getPrice());

    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(product.getCart(), product.getId(),
                product.getName(),
                product.getPrice());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(t -> new ProductDto(t.getCart(), t.getId(), t.getName(), t.getPrice()))
                .collect(Collectors.toList());
    }
}