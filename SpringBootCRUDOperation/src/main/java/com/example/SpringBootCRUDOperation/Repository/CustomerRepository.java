package com.example.SpringBootCRUDOperation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootCRUDOperation.Entity.CustomerEntity;




@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	
	List<CustomerEntity> findByEmailOrPhoneNumber(String email, String phonenumber);

}
