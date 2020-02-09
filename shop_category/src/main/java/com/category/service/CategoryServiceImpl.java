package com.category.service;

import com.category.model.Category;
import com.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementations of {@link CategoryService} interface
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category getById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Long> getAllIds(){
        return categoryRepository.findAllId();
    }

}
