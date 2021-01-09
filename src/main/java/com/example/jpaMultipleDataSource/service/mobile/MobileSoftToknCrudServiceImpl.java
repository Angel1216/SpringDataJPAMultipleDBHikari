package com.example.jpaMultipleDataSource.service.mobile;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpaMultipleDataSource.dao.mobile.ClientsRepository;
import com.example.jpaMultipleDataSource.entity.mobile.ClientsEntity;
import com.example.jpaMultipleDataSource.model.request.SoftToknCrudRequest;

@Service
public class MobileSoftToknCrudServiceImpl implements MobileSoftToknCrudService {
	
	private ClientsRepository clientsRepository;
	
	@Autowired
	public MobileSoftToknCrudServiceImpl(ClientsRepository clientsRepository) {
		this.clientsRepository = clientsRepository;
	}
	

	@Override
	public Integer removeCustomerMobile(Map<String, String> headers, SoftToknCrudRequest request) {
		
		Optional<ClientsEntity> client = clientsRepository.findById(request.getCustomerId().intValue());
		
		
		if(client.isPresent()) {
			System.out.println("Si existe el registro en base de datos");
			System.out.println(  clientsRepository.findById(request.getCustomerId().intValue()).get().toString()  );
			
			client.get().setLastName("actualizado");
			clientsRepository.save(client.get());
			
			
			return 0;
		} else {
			System.out.println("No existe le registro en base de datos");
			return 1;
		}
		
	}

}
