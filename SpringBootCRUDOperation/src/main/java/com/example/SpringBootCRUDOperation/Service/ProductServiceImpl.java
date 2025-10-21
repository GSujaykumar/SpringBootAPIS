package com.example.SpringBootCRUDOperation.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.SpringBootCRUDOperation.DTO.ProductResponse;
import com.example.SpringBootCRUDOperation.Entity.ProductEntity;
import com.example.SpringBootCRUDOperation.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public ResponseEntity<?> saveProductDetails(ProductResponse productResponse) {

		try {

			List<ProductEntity> existProduct = productRepository.findBySku(productResponse.getSku());

			if (!existProduct.isEmpty()) {
				return ResponseEntity.badRequest().body("Product already exist");
			}

			ProductEntity product = ProductEntity.builder().name(productResponse.getName())
					.description(productResponse.getDescription()).price(productResponse.getPrice())
					.category(productResponse.getCategory()).brand(productResponse.getBrand())
					.sku(productResponse.getSku()).stockQuantity(productResponse.getStockQuantity())
					.color(productResponse.getColor()).available(true).size(productResponse.getSize()).build();

			productRepository.save(product);

			return ResponseEntity.ok("Student Saved Sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Error:" + e.getMessage());
		}

	}

	@Override
	public ResponseEntity<?> saveListStudents(List<ProductResponse> productResponse) {
		try {

			List<ProductEntity> ExistProduct = productRepository
					.findBySkuIn(productResponse.stream().map(ProductResponse::getSku).collect(Collectors.toList()));

			if (!ExistProduct.isEmpty()) {
				return ResponseEntity.badRequest().body("Product Already Exist" + ExistProduct);
			}

			List<ProductEntity> products = productResponse.stream()
					.map(dto -> ProductEntity.builder().name(dto.getName()).description(dto.getDescription())
							.price(dto.getPrice()).category(dto.getCategory()).brand(dto.getBrand()).sku(dto.getSku())
							.stockQuantity(dto.getStockQuantity()).available(true).color(dto.getColor()).size(dto.getSize())

							.build())
					.collect(Collectors.toList());
			
			
			productRepository.saveAll(products);
			
			return ResponseEntity.ok("Student Saved Sucessfully");
			
			

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Error" + e.getMessage());
		}

	}

}
