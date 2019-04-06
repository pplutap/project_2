package com.kodilla.ecommercee.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kodilla.ecommercee.cart.domain.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "users")
public class User {
    private Long userId;
    private String userName;
    private String status;
    private Long userKey;
    private List<Cart> carts;

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    @Column(name = "username")
    public String getUserName() {
        return userName;
    }

    @Column(name = "user_status")
    public String getStatus() {
        return status;
    }

    @Column(name = "user_key")
    public Long getUserKey() {
        return userKey;
    }

    @OneToMany(mappedBy = "user", targetEntity = Cart.class)
    public List<Cart> getCarts() {
        return carts;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserKey(Long userKey) {
        this.userKey = userKey;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
