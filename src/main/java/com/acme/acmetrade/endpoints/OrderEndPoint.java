package com.acme.acmetrade.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acme.acmetrade.domain.Order;

@RestController
public class OrderEndPoint {
	
	@RequestMapping(value="/orders", method = RequestMethod.GET)	
	public List<Order> getOrders(){
		return new ArrayList<Order>();
	}

	@RequestMapping(path = "/orders" , method = RequestMethod.POST)
	public Order addOrder(@RequestBody Order order) {		
		return order;
	}
	
	@RequestMapping(path = "/orders/{id}" , method = RequestMethod.GET)
	public Order listOrders(@PathParam("id") int id) {
		return new Order();
	}
	
	@RequestMapping(path = "/orders/{id}" , method = RequestMethod.DELETE)
	public void deleteOrder(@PathParam("id") int id) {
	}

}
