package com.kaybee.marketplace.service;

import com.kaybee.marketplace.model.Product;
import com.kaybee.marketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void removeProductById(long id){
        productRepository.deleteById(id);
    }

    public Optional<Product> getProductById(long id){
        return productRepository.findById(id);
    }

    public List<Product> getAllProductByCategoryid(int id){
        return productRepository.findAllByCategory_Id(id);
    }
}
