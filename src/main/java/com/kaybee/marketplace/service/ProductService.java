package com.kaybee.marketplace.service;

import com.kaybee.marketplace.model.Product;
import com.kaybee.marketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* ProductService is a service layer on top of productRepository layer to perform operations on products */
@Service
public class ProductService {

    /* productRepository layer to access product data from database */
    @Autowired
    private ProductRepository productRepository;

    /* Get all products from the database via productRepository layer */
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    /* Get a single product by its id from the database via productRepository layer */
    public Optional<Product> getProductById(long id){
        return productRepository.findById(id);
    }

    /* Get all products by its category id from the database via productRepository layer */
    public List<Product> getAllProductsByCategoryId(int id){
        return productRepository.findAllByCategory_Id(id);
    }

    /* Add a single product into the database via productRepository layer */
    public void addProduct(Product product){
        productRepository.save(product);
    }

    /* Remove or Delete a single product by its id from the database via productRepository layer */
    public void removeProductById(long id){
        productRepository.deleteById(id);
    }

}
