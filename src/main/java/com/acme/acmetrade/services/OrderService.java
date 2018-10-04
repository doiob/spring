package com.acme.acmetrade.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acme.acmetrade.domain.Order;
import com.acme.acmetrade.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public int saveOrder(Order order){
    	return orderRepository.saveOrder(order);
    }
            
}