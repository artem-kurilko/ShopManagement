package com.product.repository;

import com.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface ProductRepository extends MongoRepository<Product, BigInteger> {

}
