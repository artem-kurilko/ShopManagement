package com.test;

import com.product.repository.CategoryIdRepository;
import com.product.repository.ProductRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

@TestConfiguration
public class TestProductConfiguration {

    @MockBean
    private CategoryIdRepository categoryIdRepository;

    @MockBean
    private ProductRepository productRepository;
}
