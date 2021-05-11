package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS_GROUPS")
public class Group {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "GROUP_ID", unique = true)
    private Long groupId;

    @NotNull
    @Column(name = "GROUP_NAME")
    private String groupName;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "groupId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> productList = new ArrayList<>();

    public Group(@NotNull Long groupId, @NotNull String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public Group(@NotNull String groupName) {
        this.groupName = groupName;
    }
}
