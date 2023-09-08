package com.service;


public interface ISellService {
    void savePayment(Integer id, String customerName, Integer phoneNumber, String address, Integer age,String email, String payments);
//    void savePayment(Integer id, String customerName, Integer phoneNumber, String address, Integer age,String email, String productName, Double price, Integer quantity, String payments);

}
