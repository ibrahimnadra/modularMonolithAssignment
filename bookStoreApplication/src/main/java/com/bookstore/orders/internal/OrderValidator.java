package com.bookstore.orders.internal;

import org.springframework.modulith.NamedInterface;
import org.springframework.stereotype.Component;

@NamedInterface("validator")
@Component
public class OrderValidator{

    public boolean isValid(String orderId) {
        return orderId != null && !orderId.isBlank();
    }
}
