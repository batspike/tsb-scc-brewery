package com.samcancode.events;

import org.springframework.context.ApplicationEvent;

import com.samcancode.domain.BeerOrder;
import com.samcancode.domain.OrderStatusEnum;

@SuppressWarnings("serial")
public class BeerOrderStatusChangeEvent extends ApplicationEvent {

    private final OrderStatusEnum previousStatus;

    public BeerOrderStatusChangeEvent(BeerOrder source, OrderStatusEnum prevStatus) {
        super(source);
        this.previousStatus = prevStatus;
    }

    public OrderStatusEnum getPreviousStatus() {
        return previousStatus;
    }
}