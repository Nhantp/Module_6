package com.service.impl;

import com.model.Sell;
import com.repository.ISellRepository;
import com.service.ISellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellService implements ISellService {
    @Autowired
    private ISellRepository isellRepository;

    @Override
    public void savePayment(Integer id, String customerName, Integer phoneNumber, String address, Integer age, String email, String payments) {
        isellRepository.savePayment(id, customerName, phoneNumber, address, age, email, payments);
    }

//    public void savePayment(Integer id, String customerName, Integer phoneNumber, String address, Integer age, String email, String productName, Double price, Integer quantity, String payments) {
//        isellRepository.savePayment(id, customerName, phoneNumber, address, age, email, productName, price, quantity, payments);
//    }
}
