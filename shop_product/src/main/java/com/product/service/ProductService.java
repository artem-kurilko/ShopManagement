package com.product.service;

import com.product.model.Product;

import java.math.BigInteger;
import java.util.List;

/**
 * Service interface for {@link com.product.model.Product}
 */

public interface ProductService {

    Product getById(BigInteger _id);

    void save(Product product);

    List<Product> getAll();

    List<Long> getAllCategoryIds();

}
