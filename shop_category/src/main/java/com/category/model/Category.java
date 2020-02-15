package com.category.model;

import lombok.*;

import javax.persistence.*;

/**
 * Simple JavaBean domain object that represents Category
 */

@Entity
@Table(name = "category")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

}
