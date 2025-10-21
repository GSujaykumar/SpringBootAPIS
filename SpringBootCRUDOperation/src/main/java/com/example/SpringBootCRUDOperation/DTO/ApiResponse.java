package com.example.SpringBootCRUDOperation.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

	private boolean sucess;

	private String message;

	private T Data;

}
