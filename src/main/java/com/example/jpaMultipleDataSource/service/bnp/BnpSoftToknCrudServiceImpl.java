package com.example.jpaMultipleDataSource.service.bnp;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpaMultipleDataSource.dao.bnp.TokenTransmitRepository;
import com.example.jpaMultipleDataSource.entity.bnp.TokenTransmitEntity;
import com.example.jpaMultipleDataSource.model.request.SoftToknCrudRequest;

import lombok.extern.slf4j.Slf4j;

@Service
public class BnpSoftToknCrudServiceImpl implements BnpSoftToknCrudService {
	
	private TokenTransmitRepository tokenTransmitRepository;
	
	@Autowired
	public BnpSoftToknCrudServiceImpl(TokenTransmitRepository tokenTransmitRepository) {
		this.tokenTransmitRepository = tokenTransmitRepository;
	}
	

	@Override
	public Integer removeCustomerBnp(Map<String, String> headers, SoftToknCrudRequest request) {
		
//		Optional<TokenTransmitEntity> client = tokenTransmitRepository.findById(request.getCustomerId().intValue()); 
		
		if(tokenTransmitRepository.existsById(request.getCustomerId().intValue())) {
			System.out.println("Si existe el registro en base de datos");
			System.out.println(  tokenTransmitRepository.findById(request.getCustomerId().intValue()).get().toString()  );
			
			tokenTransmitRepository.deleteById(request.getCustomerId().intValue());
			return 0;
		} else {
			System.out.println("No existe le registro en base de datos");
			return 1;
		}
		
	}

}
