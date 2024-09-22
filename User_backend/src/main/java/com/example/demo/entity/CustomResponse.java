package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

    @Data
    @AllArgsConstructor
	public class CustomResponse {
    private String message;
	public CustomResponse(String message) {
		super();
		this.message = message;
	}
}
