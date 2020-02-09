package com.product.controller;

import com.product.model.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

/**
 * Controller for {@link com.product.model.Product}
 */

@RestController
@RequestMapping(value = "/product/")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid Product product){
        HttpHeaders headers = new HttpHeaders();

        if (product == null){
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }

        // checking if categoryId exists, if yes we add to collection, if no throw not found
        List<Long> categoryIds = this.productService.getAllCategoryIds();

        boolean created = false;

        for (Long i : categoryIds) {
                if (i.equals(product.getCategoryId())) {
                    created = true;
                    this.productService.save(product);
                } break;
        }

        if (!created) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = this.productService.getAll();

       if (products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @RequestMapping(value = "{_id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Product> getProductById(@PathVariable("_id") BigInteger _id){

        if (_id==null){
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }

        Product product = productService.getById(_id);

        if (product == null){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Product>(product,HttpStatus.OK);
    }
}
