package com.kaybee.marketplace.model;

import lombok.Data;

import javax.persistence.*;

/* Category is a POJO for storing categories in the database */
@Entity
@Data
public class Category {

    /* id field represents the primary key of category table */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private int id;

    /* name field represents the category name */
    private String name;
}
