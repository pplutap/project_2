package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Item;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.GroupService;
import com.kodilla.ecommercee.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    @Autowired
    CartService cartService;
    @Autowired
    GroupService groupService;
    @Autowired
    ItemService itemService;

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                getGroupWithId(productDto.getGroupId()),
                getListItemsWithId(productDto.getItemId()));
    }

    public ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                getIdFromGroup(product.getGroup()),
                getListItemIdFromProduct(product.getItemsList()));
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

    private Group getGroupWithId(Long id) {
        if (id == null || id == 0)
            return null;
        return groupService.getGroup(id);
    }

    private Item getItemWithId(Long id) {
        if (id == null || id == 0)
            return null;
        return itemService.getItem(id);
    }

    private List<Item> getListItemsWithId(List<Long> itemsId) {
        if (itemsId == null)
            return new ArrayList<>();
        return itemsId.stream()
                .map(this::getItemWithId)
                .collect(Collectors.toList());
    }

    private Long getIdFromGroup(Group group) {
        try {
            return group.getGroupId();
        } catch (Exception e) {
            return null;
        }
    }

    private List<Long> getListItemIdFromProduct(List<Item> items) {
        try {
            return items.stream()
                    .map(Item::getId)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}