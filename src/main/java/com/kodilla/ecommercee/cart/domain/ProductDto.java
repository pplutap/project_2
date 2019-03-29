package com.kodilla.ecommercee.cart.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {
    @JsonProperty("productId")
    private Long productId;

    @JsonProperty("productName")
    private String productName;

    public ProductDto(Long productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
}
