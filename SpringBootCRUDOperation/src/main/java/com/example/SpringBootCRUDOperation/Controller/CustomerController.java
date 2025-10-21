package com.example.SpringBootCRUDOperation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootCRUDOperation.DTO.CustomerResponse;
import com.example.SpringBootCRUDOperation.Service.CustomerService;

@RestController
@RequestMapping("/v2/api")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/saveCustomerDetails")
	public ResponseEntity<?> saveCustomerDetails(@RequestBody List<CustomerResponse> customerResponse) {
		try {
			return customerService.saveCustomer(customerResponse);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Unable to save Details" + e.getMessage());
		}

	}

	@GetMapping("/getCustomerDetails")
	public ResponseEntity<?> getCustomerDetails() {
		try {  
			return customerService.getCustomerDetails();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Unable to save Details" + e.getMessage());
		}

	}

	@GetMapping("/getCustomerDetailsBy/{id}")
	public ResponseEntity<?> getCustomerDetailsBy(@PathVariable Long id) {
		try {
			return customerService.getCustomerDetailsBy(id);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Unable to save Details" + e.getMessage());
		}

	}
	
	
	@DeleteMapping("/getCustomerDetailsById/{id}")
	public ResponseEntity<?> getCustomerDetailsById(@PathVariable Long id) {
		try {
			return customerService.deleteCustomerById(id);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Unable to save Details" + e.getMessage());
		}

	}


}
