package com.kodilla.ecommercee.domain;

public class Cart {

    private Long cartId;
    // private User user;
    // private Order order;

    public Cart(Long cartId){
        this.cartId = cartId;
    }

    public Long getCardId(){
        return cartId;
    }

    public void setCartId(Long cartId){
        this.cartId = cartId;
    }
}
