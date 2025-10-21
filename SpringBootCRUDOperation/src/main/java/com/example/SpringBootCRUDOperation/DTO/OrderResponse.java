package com.example.SpringBootCRUDOperation.DTO;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {

	private String orderNumber;
	private Long customerId;
	private LocalDateTime orderDate;
	private LocalDateTime deliveryDate;
	private Double totalAmount;
	private String paymentMethod;
	private String shippingAddress;
	private String billingAddress;
	private String status; 
	private Boolean giftWrap;
	private String deliveryInstructions;
	private Integer itemCount;
	private List<String> productSkus;

}
