package com.example.SpringBootCRUDOperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootCRUDOperation.Entity.OrderEntity;



@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
