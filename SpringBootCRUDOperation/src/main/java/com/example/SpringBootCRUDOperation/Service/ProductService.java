package com.example.SpringBootCRUDOperation.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.SpringBootCRUDOperation.DTO.ProductResponse;

public interface ProductService {
	
	public ResponseEntity<?>saveProductDetails(ProductResponse productResponse);
	
	public ResponseEntity<?>saveListStudents(List<ProductResponse>productResponse );

}
