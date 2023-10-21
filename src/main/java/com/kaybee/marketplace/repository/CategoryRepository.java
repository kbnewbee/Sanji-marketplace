package com.kaybee.marketplace.repository;

import com.kaybee.marketplace.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/* CategoryRepository is a repository layer which extends JpaRepository to perform operations on Category table in the database */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
