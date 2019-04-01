package com.kodilla.ecommercee.cart.domain;

import com.kodilla.ecommercee.user.domain.UserDto;
import com.kodilla.ecommercee.product.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Cart {

    private Long cartId;

    private List<ProductDto> productDtoList;

    private UserDto userDto;
}
