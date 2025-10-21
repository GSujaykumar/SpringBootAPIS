package com.example.SpringBootCRUDOperation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.SpringBootCRUDOperation.DTO.CustomerResponse;
import com.example.SpringBootCRUDOperation.Entity.CustomerEntity;
import com.example.SpringBootCRUDOperation.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

//	@Override
//	public ResponseEntity<?> saveCustomer(CustomerResponse customerResponse) {
//
//		try {
//			
//			List<CustomerEntity> DetailsExists = customerRepository.findByEmailOrPhoneNumber(customerResponse.getEmail(),customerResponse.getPhoneNumber());
//			
//			
//			if(!DetailsExists.isEmpty()) {
//				return ResponseEntity.badRequest().body("Customer Details Already Exists:" + DetailsExists);
//			}
//			
//			CustomerEntity customerDetails = 
//					CustomerEntity.builder().firstName(customerResponse.getFirstName())
//					.lastName(customerResponse.getLastName()).email(customerResponse.getEmail())
//					.phoneNumber(customerResponse.getPhoneNumber()).address(customerResponse.getAddress())
//					.city(customerResponse.getCity()).state(customerResponse.getState())
//					.country(customerResponse.getCountry()).postalCode(customerResponse.getPostalCode()).build();
//
//			customerRepository.save(customerDetails);
//
//			return ResponseEntity.ok("Customer Details Saved Sucessfully");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.badRequest().body("Unable to save Details" + e.getMessage());
//		}
//	}

//	@Override
//	public ResponseEntity<?> saveCustomer(CustomerResponse customerResponse) {
//
//		try {
//
//			CustomerEntity customer = CustomerEntity.builder().firstName(customerResponse.getFirstName())
//					.lastName(customerResponse.getLastName()).email(customerResponse.getEmail())
//					.phoneNumber(customerResponse.getPhoneNumber()).address(customerResponse.getAddress())
//					.city(customerResponse.getCity()).state(customerResponse.getState())
//					.country(customerResponse.getCountry()).postalCode(customerResponse.getPostalCode()).build();
//
//			customerRepository.save(customer);
//
//			return ResponseEntity.ok("Customer Details Saved Sucessfully");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.badRequest().body("Unable to save Details" + e.getMessage());
//		}
//
//	}

	@Override
	public ResponseEntity<?> saveCustomer(List<CustomerResponse> customerList) {

		try {

			List<CustomerEntity> customerEntityList = customerList.stream()
					.map(customerResponse -> CustomerEntity.builder()

							.firstName(customerResponse.getFirstName()).lastName(customerResponse.getLastName())
							.email(customerResponse.getEmail()).phoneNumber(customerResponse.getPhoneNumber())
							.address(customerResponse.getAddress()).city(customerResponse.getCity())
							.state(customerResponse.getState()).country(customerResponse.getCountry())
							.postalCode(customerResponse.getPostalCode()).build()

					).toList();

			customerRepository.saveAll(customerEntityList);

			return ResponseEntity.ok("Customer Details Saved Sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Unable to save Details" + e.getMessage());
		}

	}

	@Override
	public ResponseEntity<?> getCustomerDetails() {
		try {

			List<CustomerEntity> Customer = customerRepository.findAll();

			if (Customer.isEmpty()) {
				return ResponseEntity.ok("Unable to Fetch Customoer Details");
			}

			return ResponseEntity.ok(Customer);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Unable to Get Cusotmer Details" + e.getMessage());
		}

	}

	@Override
	public ResponseEntity<?> getCustomerDetailsBy(Long id) {
		try {

			Optional<CustomerEntity> cusotmerDetials = customerRepository.findById(id);
			System.out.println("Fetching customer with ID: " + id);

			if (cusotmerDetials.isPresent()) {
				return ResponseEntity.ok(cusotmerDetials);

			}

			return ResponseEntity.ok("Unable to Fetch Customoer Details");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Unable to Get Cusotmer Details" + e.getMessage());
		}

	}

	@Override
	public ResponseEntity<?> deleteCustomerById(Long id) {
		try {
			Optional<CustomerEntity> customers = customerRepository.findById(id);

			if (customers.isPresent()) {

				customerRepository.deleteById(id);
				return ResponseEntity.ok("Customer Deleted Sucessfully");
			}

			return ResponseEntity.ok("Unable to delete customer Details" + "Customer Id:" + id);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Unable to Get Cusotmer Details" + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> updateCusomerById(Long id, CustomerResponse customerResponse) {

		try {

			Optional<CustomerEntity> customerDetails = customerRepository.findById(id);

			if (customerDetails.isPresent()) {

				CustomerEntity customerRespons = CustomerEntity.builder().firstName(customerResponse.getFirstName())
						.lastName(customerResponse.getLastName()).email(customerResponse.getEmail())
						.phoneNumber(customerResponse.getPhoneNumber()).address(customerResponse.getAddress())
						.city(customerResponse.getCity()).state(customerResponse.getState())
						.country(customerResponse.getCountry()).postalCode(customerResponse.getPostalCode()).build();

				customerRepository.save(customerRespons);
				return ResponseEntity.ok("Customer updated Sucessfully");

			}

			return ResponseEntity.ok("Unable to delete customer Details" + "Customer Id:" + id);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Unable to update Customer Details:" + e.getMessage());
		}

	}

}
