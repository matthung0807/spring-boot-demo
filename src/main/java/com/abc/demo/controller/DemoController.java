package com.abc.demo.controller;

import com.abc.demo.enumeration.Shipper;
import com.abc.demo.service.ShippingService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private BeanFactory beanFactory;

    @PostMapping("/ship/{shipper}/{orderId}")
    public void ship(@PathVariable String shipper, @PathVariable String orderId) {
        Shipper shipperEnum = Shipper.of(shipper);
        if (shipperEnum == null) {
            throw new IllegalArgumentException("shipper=" + shipper);
        }

        ShippingService shippingService =
                beanFactory.getBean(shipperEnum.getShippingServiceClass()); // 依Class取得對應的bean

        shippingService.ship(orderId);

    }

}
