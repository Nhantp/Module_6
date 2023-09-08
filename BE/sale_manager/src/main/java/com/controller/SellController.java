package com.controller;

import com.model.Product;
import com.model.Sell;
import com.service.IProductService;
import com.service.ISellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class SellController {
    @Autowired
    private ISellService iSellService;
    @Autowired
    private IProductService iProductService;

    @PostMapping("/payment")
    public ResponseEntity<Void> payment(@RequestBody Sell sell) {
        this.iSellService.savePayment(sell.getId(), sell.getCustomerName(), sell.getPhoneNumber(), sell.getAddress(), sell.getAge(),
                sell.getEmail(), sell.getPayments());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @PostMapping("/payment")
//    public ResponseEntity<Void> payment(@RequestBody Sell sell) {
//        this.iSellService.savePayment(sell.getId(), sell.getCustomerName(), sell.getPhoneNumber(), sell.getAddress(), sell.getAge(),
//                sell.getEmail(), sell.getProductName(), sell.getPrice(), sell.getQuantity(), sell.getPayments());
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

}
