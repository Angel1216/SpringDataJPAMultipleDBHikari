package com.example.jpaMultipleDataSource.dao.mobile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpaMultipleDataSource.entity.mobile.ClientsEntity;

@Repository
public interface ClientsRepository extends JpaRepository<ClientsEntity, Integer>{

}
