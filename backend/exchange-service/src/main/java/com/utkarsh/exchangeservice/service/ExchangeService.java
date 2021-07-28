package com.utkarsh.exchangeservice.service;

import com.utkarsh.exchangeservice.entity.Exchange;
import com.utkarsh.exchangeservice.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExchangeService {

    @Autowired
    private ExchangeRepository exchangeRepository;


    public List<Exchange> getAllExchanges() {
        return exchangeRepository.findAll();
    }

    public Exchange getExchangeById(int id) {
        Optional<Exchange> exchange = exchangeRepository.findById(id);
        if (exchange.isPresent()) {
            return exchange.get();
        }
        else {
            return null;
        }
    }

    public Exchange addExchange(Exchange exchange) {
        return exchangeRepository.save(exchange);
    }

}
