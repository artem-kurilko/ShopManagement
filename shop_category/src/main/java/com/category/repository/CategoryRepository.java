package com.category.repository;

import com.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link com.category.model.Category} class
 */

public interface CategoryRepository extends JpaRepository<Category,Long> {

    /*@Query("select c.id from Category c")
    List<Long> findAllId();*/
}
