package com.example.SpringBootCRUDOperation.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.SpringBootCRUDOperation.DTO.OrderResponse;
import com.example.SpringBootCRUDOperation.Entity.OrderEntity;
import com.example.SpringBootCRUDOperation.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
	
	
	
	
	@Override
	public boolean saveOrderDetail(List<OrderResponse> orderResponses) {
		
		List<OrderEntity> orderDetails = orderResponses.stream().map(dto -> OrderEntity.builder()
				
				
				).toList();

		return false;
	}

}
