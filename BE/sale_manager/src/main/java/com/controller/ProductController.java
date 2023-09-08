package com.controller;

import com.model.Product;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @PostMapping("/product-create")
    public ResponseEntity<Product> saveProduct(@RequestBody List<Product> productList) {
         this.iProductService.saveAll(productList);
         return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
