package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "sell")
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    private String customerId;
    private String customerName;
    private int phoneNumber;
    private String address;
//    private String dateOfBirthday;
    private int age;
    private String email;
//    private String productId;
//    private String productName;
//    private double price;
//    private int quantity;
//    private double totalAmount;
    private String payments;
//    private String bill;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

