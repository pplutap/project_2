package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GroupDto {
    private Long groupId;
    private String groupName;
    private List<ProductDto> productsList = new ArrayList<>();
}