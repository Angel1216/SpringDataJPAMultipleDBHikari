package com.example.jpaMultipleDataSource.service.bnp;

import java.util.Map;

import com.example.jpaMultipleDataSource.model.request.SoftToknCrudRequest;

public interface BnpSoftToknCrudService {
	
	Integer removeCustomerBnp(Map<String, String> headers,
			SoftToknCrudRequest request);

}
