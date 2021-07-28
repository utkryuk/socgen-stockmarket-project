package com.utkarsh.exchangeservice.repository;

import com.utkarsh.exchangeservice.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {

}