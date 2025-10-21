package com.example.SpringBootCRUDOperation.Service;

import java.util.List;

import com.example.SpringBootCRUDOperation.DTO.OrderResponse;


public interface OrderService {
	
	boolean saveOrderDetail(List<OrderResponse> orderResponses);

}
