package com.example.SpringBootCRUDOperation.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.SpringBootCRUDOperation.DTO.CustomerResponse;

public interface CustomerService {
	
	public ResponseEntity<?> saveCustomer(List<CustomerResponse> customerResponse);
	
	public ResponseEntity<?> getCustomerDetails();
	
	public ResponseEntity<?> getCustomerDetailsBy(Long id);
	
	public ResponseEntity<?> deleteCustomerById(Long id);
	
	public ResponseEntity<?>updateCusomerById(Long id, CustomerResponse customerResponse);

}
