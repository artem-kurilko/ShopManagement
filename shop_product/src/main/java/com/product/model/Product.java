package com.product.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;

@Document(collection = "product")
@Getter
@Setter
public class Product {

    @Id
    private BigInteger _id;

    @Field(value = "categoryId")
    private Long categoryId;

    @Field(value = "name")
    private String name;
}
