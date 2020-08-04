package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.domains.Product;
import com.kodilla.ecommercee.domains.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private GroupMapper groupMapper;


    public Product mapToProduct(final ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getQuantity(),
                orderMapper.mapToOrderList(productDto.getOrderDto()),
                cartMapper.mapToCartList(productDto.getCartDto()),
                groupMapper.mapToGroup(productDto.getGroupDto()));
    }

    public ProductDto mapToProductDto(final Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                orderMapper.mapToOrderDtoList(product.getOrders()),
                cartMapper.mapToCartDtoList(product.getCarts()),
                groupMapper.mapToGroupDto(product.getGroup()));
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList){
        return productList.stream()
                .map(t -> new ProductDto(
                        t.getId(),
                        t.getName(),
                        t.getPrice(),
                        t.getQuantity(),
                        orderMapper.mapToOrderDtoList(t.getOrders()),
                        cartMapper.mapToCartDtoList(t.getCarts()),
                        groupMapper.mapToGroupDto(t.getGroup())))
                .collect(Collectors.toList());
    }
    public List<Product> mapToProductList(final List<ProductDto> productDtoList){
        return productDtoList.stream()
                .map(t -> new Product(
                        t.getId(),
                        t.getName(),
                        t.getPrice(),
                        t.getQuantity(),
                        orderMapper.mapToOrderList(t.getOrderDto()),
                        cartMapper.mapToCartList(t.getCartDto()),
                        groupMapper.mapToGroup(t.getGroupDto())))
                .collect(Collectors.toList());
    }
}
