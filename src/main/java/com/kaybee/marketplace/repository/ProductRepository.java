package com.kaybee.marketplace.repository;

import com.kaybee.marketplace.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findAllByCategory_Id(int id);
}
