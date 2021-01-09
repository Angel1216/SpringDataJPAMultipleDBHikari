package com.example.jpaMultipleDataSource.model.request;

import java.math.BigInteger;

import lombok.Data;

@Data
public class SoftToknCrudRequest {
	
	private BigInteger customerId;

	public BigInteger getCustomerId() {
		return customerId;
	}

	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}
	
	

}
