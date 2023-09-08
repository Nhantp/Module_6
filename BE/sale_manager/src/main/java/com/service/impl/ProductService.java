package com.service.impl;
import com.model.Product;
import com.repository.IProductRepository;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public void saveAll(List<Product> products) {
        iProductRepository.saveAll(products);
    }


    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }
}
