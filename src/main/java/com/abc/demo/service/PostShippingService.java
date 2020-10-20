package com.abc.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PostShippingService implements ShippingService {

    @Override
    public void ship(String orderId) {
        System.out.println("郵局出貨, orderId=" + orderId);
    }

}
