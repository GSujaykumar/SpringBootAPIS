package com.example.SpringBootCRUDOperation.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringBootCRUDOperation.DTO.ApiResponse;
import com.example.SpringBootCRUDOperation.DTO.OrderResponse;
import com.example.SpringBootCRUDOperation.Service.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping("/bulk-save")
	public ResponseEntity<ApiResponse<Void>> saveCustomers(@RequestBody List<OrderResponse> orderList) {
		boolean saved = orderService.saveOrderDetail(orderList);
		if (saved) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ApiResponse<>(true, "Customers saved successfully", null));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse<>(false, "Failed to save customers", null));
		}
	}

}
