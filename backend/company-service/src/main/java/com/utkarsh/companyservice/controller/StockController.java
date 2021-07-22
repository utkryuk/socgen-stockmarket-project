package com.utkarsh.companyservice.controller;

import com.utkarsh.companyservice.entity.Stock;
import com.utkarsh.companyservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/getStocks")
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity
                .ok(stockService.getAllStocks());
    }

    @GetMapping("/getStocks/{id}")
    public ResponseEntity<?> getStockById(@PathVariable(value = "id") int id) {
        Stock stock = stockService.getStockById(id);
        if (stock == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No Stock found");
        }

        return ResponseEntity
                .ok(stock);
    }

    @PostMapping("/getStocks")
    public ResponseEntity<Stock> createStocks(@RequestBody Stock stock) {
        return ResponseEntity
                .ok(stockService.addStock(stock));
    }


}
