package com.abc.demo.service;

import org.springframework.stereotype.Service;

@Service
public class TcatShippingService implements ShippingService {

    @Override
    public void ship(String orderId) {
        System.out.println("黑貓出貨, orderId=" + orderId);
    }

}
