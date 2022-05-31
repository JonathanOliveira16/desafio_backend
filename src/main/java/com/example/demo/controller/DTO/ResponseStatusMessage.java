package com.example.demo.controller.DTO;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseStatusMessage {
	private String message;
	private HttpStatus code;
	
	
}
