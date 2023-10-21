package com.kaybee.marketplace.model;

import lombok.Data;

import javax.persistence.*;

/* Product is a POJO for storing products in the database */
@Entity
@Data
public class Product {

    /* id field represents the primary key of product table */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /* name field represents the product name */
    private String name;

    /* category field represents the category of the product
    *  @ManyToOne relationship because -> one category can have multiple product, but one product can have only one category
    *  using category_id as a foreign key and reference column
    * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    /* price field represents the product price */
    private double price;

    /* weight field represents the product weight in grams */
    private double weight;

    /* description field represents the product description */
    private String description;

    /* imageName field represents the name of the product image */
    private String imageName;
}
