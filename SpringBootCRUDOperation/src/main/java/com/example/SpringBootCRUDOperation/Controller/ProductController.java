package com.example.SpringBootCRUDOperation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootCRUDOperation.DTO.ProductResponse;
import com.example.SpringBootCRUDOperation.Service.ProductService;

@RequestMapping("/v1/api")
@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/saveProductDetails")
	public ResponseEntity<?> saveProductDetails(@RequestBody ProductResponse productResponse) {
		try {
			return productService.saveProductDetails(productResponse);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Unable to save Product Details");
		}

	}

	@PostMapping("/saveListProductDetails")
	public ResponseEntity<?> saveListProductDetails(@RequestBody List<ProductResponse> productResponse) {
		try {
			return productService.saveListStudents(productResponse);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

}
