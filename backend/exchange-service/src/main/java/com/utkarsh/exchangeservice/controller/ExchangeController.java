package com.utkarsh.exchangeservice.controller;

import com.utkarsh.exchangeservice.entity.Exchange;
import com.utkarsh.exchangeservice.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exchanges")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/")
    public ResponseEntity<List<Exchange>>  getExchanges() {
        return ResponseEntity
            .ok(exchangeService.getAllExchanges());
    }

    @GetMapping("/{id}")
    public ResponseEntity getExchangeById(@PathVariable(value = "id") int id) {
        Exchange exchange = exchangeService.getExchangeById(id);

        if (exchange == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No Stock exchange found");
        }

        return ResponseEntity.ok(exchange);
    }

    @PostMapping("/")
    public ResponseEntity<Exchange> addExchange(@RequestBody Exchange exchange) {
        return ResponseEntity.ok(exchangeService.addExchange(exchange));
    }
}
