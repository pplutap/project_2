package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GROUP")
public class Group {

    @Id
    @GeneratedValue
    @NotNull
    @Getter
    @Setter
    @Column(name = "ID")
    private Long id;

    @Getter
    @Setter
    @Column(name = "NAME")
    private String name;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @Getter
    @Setter
    private List<Product> products = new ArrayList<>();
}
