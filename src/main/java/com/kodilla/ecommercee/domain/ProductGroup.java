package com.kodilla.ecommercee.domain;

import lombok.Data;
import org.hibernate.type.ListType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity(name = "PRODUCT_GROUP")
public class ProductGroup {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "GROUP_ID")
    private Long groupId;
    @Column(name = "GROUP_NAME")
    private String groupName;
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "productGroup",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> productList = new ArrayList<>();

}
