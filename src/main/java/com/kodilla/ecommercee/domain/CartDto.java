package com.kodilla.ecommercee.domain;

public class CartDto {

    private Long cartId;

    public CartDto(Long cartId){
        this.cartId = cartId;
    }

    public Long getCardId(){
        return cartId;
    }

    public void setCartId(Long cartId){
        this.cartId = cartId;
    }
}
