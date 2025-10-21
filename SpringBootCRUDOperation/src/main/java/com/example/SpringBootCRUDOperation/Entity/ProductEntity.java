package com.example.SpringBootCRUDOperation.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ProductDetails")
public class ProductEntity {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private Double price;

    private String category;

    private String brand;

    
    @Column(unique = true)
    private String sku;

    private Integer stockQuantity;

    private String color;

	private String size;
	
	
	@Column(nullable = false)
	@Builder.Default
	private Boolean available = true;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;
    
    
    @PrePersist
    protected void productCreate() {
    	createdOn = LocalDateTime.now();
    	updatedOn = LocalDateTime.now();
		
	}
    
    @PreUpdate
    protected void productUpdated() {
    	
    	updatedOn = LocalDateTime.now();
		
	}
    
    
    
    
   
    
    

}