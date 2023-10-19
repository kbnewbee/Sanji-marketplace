package com.kaybee.marketplace.repository;

import com.kaybee.marketplace.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
