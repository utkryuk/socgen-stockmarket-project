package com.utkarsh.exchangeservice.repositories;

import com.utkarsh.exchangeservice.entities.Exchange;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExchangeRepository extends MongoRepository<Exchange, Integer>{

}