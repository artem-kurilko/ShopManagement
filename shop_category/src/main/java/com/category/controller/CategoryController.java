package com.category.controller;

import com.category.model.Category;
import com.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for {@link com.category.model.Category}
 */

@RestController
@RequestMapping(value = "/category/")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @RequestMapping(value = "{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long id){

        if (id == null){
            return new ResponseEntity<Category>(HttpStatus.BAD_REQUEST);
        }

        Category category = categoryService.getById(id);

        if (category == null){
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @RequestMapping(value = "",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Category> saveCategory(@RequestBody @Valid Category category){
        HttpHeaders headers = new HttpHeaders();

        if (category == null){
            return new ResponseEntity<Category>(HttpStatus.BAD_REQUEST);
        }

        this.categoryService.save(category);
        return new ResponseEntity<Category>(category,headers,HttpStatus.CREATED);
    }

    @RequestMapping(value = "",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = this.categoryService.getAll();

        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

}
