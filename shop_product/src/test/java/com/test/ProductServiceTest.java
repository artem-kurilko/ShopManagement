package com.test;
import com.product.model.Product;
import com.product.service.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ProductServiceImpl.class, TestProductConfiguration.class})
public class ProductServiceTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void testSuccessSave() {
        when(productService.save(any(Product.class))).thenReturn(buildProduct());
        Product product = productService.save(buildProduct());
        assertNotNull(product);
    }

    private Product buildProduct() {
        return Product.builder()
                .id(new BigInteger("1"))
                .categoryId(1L)
                .name("Product name")
                .build();
    }
}