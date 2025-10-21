package com.example.SpringBootCRUDOperation.Entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "t_Orders")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String orderNumber;

	@Column(nullable = false)
	private Long customerId;

	private LocalDateTime orderDate;

	private LocalDateTime deliveryDate;

	private Double totalAmount;

	private String paymentMethod;

	private String shippingAddress;

	private String billingAddress;

	private String status;

	private Boolean giftWrap;

	private String deliveryInstructions;

	private Integer itemCount;

	@ElementCollection
	private List<String> productSkus;

	private LocalDateTime createdOn;

	private LocalDateTime updatedOn;

	@PrePersist
	protected void onCreate() {
		createdOn = LocalDateTime.now();
		updatedOn = LocalDateTime.now();
		if (giftWrap == null)
			giftWrap = false;
	}

	@PreUpdate
	protected void onUpdate() {
		updatedOn = LocalDateTime.now();
	}

}
