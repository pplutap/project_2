package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductDto {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
//    @Column(name = "name")
    private String title;
//    @Column(name = "description")
    private String content;
}
