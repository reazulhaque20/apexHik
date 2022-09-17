package com.apex.hik.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Country {
    private String name;
    private Boolean independent;
}