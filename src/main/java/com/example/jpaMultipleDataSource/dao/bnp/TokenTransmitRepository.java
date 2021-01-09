package com.example.jpaMultipleDataSource.dao.bnp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpaMultipleDataSource.entity.bnp.TokenTransmitEntity;

@Repository
public interface TokenTransmitRepository extends JpaRepository<TokenTransmitEntity, Integer>{

}
