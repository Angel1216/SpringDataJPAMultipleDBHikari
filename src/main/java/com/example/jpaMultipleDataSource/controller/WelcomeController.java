package com.example.jpaMultipleDataSource.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpaMultipleDataSource.model.request.SoftToknCrudRequest;
import com.example.jpaMultipleDataSource.service.bnp.BnpSoftToknCrudService;
import com.example.jpaMultipleDataSource.service.mobile.MobileSoftToknCrudService;


@RestController
public class WelcomeController {
	
	private BnpSoftToknCrudService bnpSoftToknCrudService;
	
	private MobileSoftToknCrudService mobileSoftToknCrudService;
	
	@Autowired
	public WelcomeController(BnpSoftToknCrudService bnpSoftToknCrudService,
			MobileSoftToknCrudService mobileSoftToknCrudService) {
		this.bnpSoftToknCrudService = bnpSoftToknCrudService;
		this.mobileSoftToknCrudService = mobileSoftToknCrudService;
	}
	
	@DeleteMapping(value = "/deleteBnp")
	public ResponseEntity<Integer> removeCustomerBnp(
			@RequestBody SoftToknCrudRequest request,
			@RequestHeader HttpHeaders httpHeaders) {
		
		
		Map<String, String> headers = new HashMap<>();
		
		Integer response = bnpSoftToknCrudService
				.removeCustomerBnp(headers, request);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/deleteMobile")
	public ResponseEntity<Integer> removeCustomerMobile(
			@RequestBody SoftToknCrudRequest request,
			@RequestHeader HttpHeaders httpHeaders) {
		
		Map<String, String> headers = new HashMap<>();
		
		Integer response = mobileSoftToknCrudService
				.removeCustomerMobile(headers, request);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}


}
