package com.kodilla.ecommercee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="CARTS")
public class Cart   {


    private List<Product> products;
   // private Order connectedOrder;
    private Long id;

    public Cart() {
        products = new ArrayList<>();
    }

    @OneToMany( targetEntity = Product.class,
                mappedBy = "cart",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    public List<Product> getProducts() {
        return products;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
