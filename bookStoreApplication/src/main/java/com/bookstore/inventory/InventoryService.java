package com.bookstore.inventory;

import com.bookstore.orders.internal.OrderValidator;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final OrderValidator validator;

    public InventoryService(OrderValidator validator) {
        this.validator = validator;
    }
}