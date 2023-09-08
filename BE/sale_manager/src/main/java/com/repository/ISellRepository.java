package com.repository;

import com.model.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface ISellRepository extends JpaRepository<Sell, Long>{
    @Modifying
    @Query(value = "insert into sell(id,customer_name,phone_number,address,age,email,payments)\n" +
            "values(?1, ?2, ?3, ?4, ?5, ?6, ?7);", nativeQuery = true)
    void savePayment(Integer id, String customerName, Integer phoneNumber, String address, Integer age,String email, String payments);

//    @Query(value = "insert into sell(id,customer_name,phone_number,address,age,email,product_name,price,quantity,payments)\n" +
//            "values(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10);", nativeQuery = true)
//    void savePayment(Integer id, String customerName, Integer phoneNumber, String address, Integer age,String email, String productName, Double price, Integer quantity, String payments);
}
