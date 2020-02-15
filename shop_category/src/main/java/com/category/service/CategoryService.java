package com.category.service;

import com.category.model.Category;

import java.util.List;

/**
 * Service interface for {@link com.category.model.Category}
 */

public interface CategoryService {

    Category getById(Long id);

    Category save(Category category);

    List<Category> getAll();

    /*List<Long> getAllIds();*/
}
