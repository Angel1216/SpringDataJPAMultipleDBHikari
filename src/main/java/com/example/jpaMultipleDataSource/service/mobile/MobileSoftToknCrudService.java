package com.example.jpaMultipleDataSource.service.mobile;

import java.util.Map;

import com.example.jpaMultipleDataSource.model.request.SoftToknCrudRequest;

public interface MobileSoftToknCrudService {
	
	Integer removeCustomerMobile(Map<String, String> headers,
			SoftToknCrudRequest request);

}
