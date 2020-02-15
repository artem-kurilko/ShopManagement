package com.product.service;

import com.product.model.Product;
import com.product.repository.CategoryIdRepository;
import com.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * Implementation of {@link ProductService} interface
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryIdRepository categoryIdRepository;

    @Override
    public Product getById(BigInteger _id) {
       return productRepository.findOne(_id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @Override
    public List<Long> getAllCategoryIds() {
        return categoryIdRepository.findAllId();
    }

}
