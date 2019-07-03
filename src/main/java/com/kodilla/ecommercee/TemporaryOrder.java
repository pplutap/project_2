package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TemporaryOrder {
    private Long id;
    private Long userId;
    private Map<String, Integer> productList;
}
