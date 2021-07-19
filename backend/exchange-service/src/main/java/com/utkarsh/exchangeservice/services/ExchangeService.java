package com.utkarsh.exchangeservice.services;

import com.utkarsh.exchangeservice.repositories.ExchangeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ExchangeService {

    private ExchangeRepository exchangeRepository;

    @GetMapping(path=  "")
    public ResponseEntity
}
