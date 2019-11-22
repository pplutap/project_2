package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Access;
import javax.persistence.AccessType;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Access(AccessType.FIELD)
public class OrderDto {
    private String name;
    private String description;
}
