package com.service;
import com.model.Product;
import java.util.List;

public interface IProductService {
    void saveAll(List<Product> products);
    List<Product> findAll();
}
