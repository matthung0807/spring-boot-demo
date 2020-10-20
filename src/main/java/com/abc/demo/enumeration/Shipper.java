package com.abc.demo.enumeration;

import com.abc.demo.service.PostShippingService;
import com.abc.demo.service.ShippingService;
import com.abc.demo.service.TcatShippingService;
import lombok.Getter;

public enum Shipper {

    TCAT("tcat", TcatShippingService.class),
    POST("post", PostShippingService.class);

    @Getter
    private final String name;
    @Getter
    private final Class<? extends ShippingService> shippingServiceClass;

    Shipper(String name, Class<? extends ShippingService> shippingServiceClass) {
        this.name = name;
        this.shippingServiceClass = shippingServiceClass;
    }

    public static Shipper of(String name) {
        for (Shipper shipper : Shipper.values()) {
            if (shipper.getName().equalsIgnoreCase(name)) {
                return shipper;
            }
        }
        return null;
    }

}
