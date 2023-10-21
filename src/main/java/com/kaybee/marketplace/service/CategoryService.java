package com.kaybee.marketplace.service;

import com.kaybee.marketplace.model.Category;
import com.kaybee.marketplace.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* CategoryService is a service layer on top of categoryRepository layer to perform operations on categories */
@Service
public class CategoryService {

    /* categoryRepository layer to access category data from database */
    @Autowired
    private CategoryRepository categoryRepository;

    /* Add a single category into the database via categoryRepository layer */
    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    /* Get a single category by its id from the database via categoryRepository layer */
    public Optional<Category> getCategoryById(int id){
        return categoryRepository.findById(id);
    }

    /* Get all categories from the database via categoryRepository layer */
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    /* Remove or Delete a single category by its id from the database via categoryRepository layer */
    public void removeCategoryById(int id){
        categoryRepository.deleteById(id);
    }

}
