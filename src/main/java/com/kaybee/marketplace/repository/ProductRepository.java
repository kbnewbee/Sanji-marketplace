package com.kaybee.marketplace.repository;

import com.kaybee.marketplace.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/* ProductRepository is a repository layer which extends JpaRepository to perform operations on Product table in the database */
public interface ProductRepository extends JpaRepository<Product, Long> {

    /* Get all products by its category id from the database */
    public List<Product> findAllByCategory_Id(int id);
}
