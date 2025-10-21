package com.example.SpringBootCRUDOperation.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

	private Long id;
	private String name;
	private String description;
	private Double price;
	private String category;
	private String brand;
	private String sku;
	private Integer stockQuantity;
	private String color;
	private String size;
	
	
	
}