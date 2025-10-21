package com.example.SpringBootCRUDOperation.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootCRUDOperation.Entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	
	List<ProductEntity> findBySku(String sku);
	
	List<ProductEntity> findBySkuIn(List<String> skus);


}
