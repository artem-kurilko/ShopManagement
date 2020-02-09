package com.product.repository;

import com.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryIdRepository extends JpaRepository<Category,Long> {
    @Query("select c.id from Category c")
    List<Long> findAllId();
}
