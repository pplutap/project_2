package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    @Autowired
    CartService cartService;
    @Autowired
    GroupService groupService;

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                createCart(productDto.getCartId()),
                createGroup(productDto.getGroupId()));
    }

    public ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                getIdFromCart(product.getCart()),
                getIdFromGroup(product.getGroup()));
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList
                .stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(final List<ProductDto> productDtoList){
        return productDtoList
                .stream()
                .map(this::mapToProduct)
                .collect(Collectors.toList());
    }

    private Cart createCart(Long id) {
        if (id == null || id == 0)
            return null;
        return cartService.getCart(id);
    }

    private Group createGroup(Long id) {
        if (id == null || id == 0)
            return null;
        return groupService.getGroup(id);
    }

    private Long getIdFromCart(Cart cart) {
        try {
            return cart.getCartId();
        } catch (Exception e) {
            return null;
        }
    }

    private Long getIdFromGroup(Group group) {
        try {
            return group.getGroupId();
        } catch (Exception e) {
            return null;
        }
    }
}