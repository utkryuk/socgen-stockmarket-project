package com.utkarsh.companyservice.controller;

import com.utkarsh.companyservice.entity.StockPrice;
import com.utkarsh.companyservice.service.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class StockPriceController {

    @Autowired
    private StockPriceService stockPriceService;

    @GetMapping("/getStockPrice")
    public ResponseEntity<List<StockPrice>> getAllStockPrices() {
        return ResponseEntity
                .ok(stockPriceService.getAllStockPrices());
    }

    @GetMapping("/getStockPrice/{id}")
    public ResponseEntity<?> getStockPriceById(@PathVariable(value = "id") int id) {
        StockPrice stockPrice = stockPriceService.getStockPriceById(id);

        if (stockPrice == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No stock price found");
        }

        return ResponseEntity
                .ok(stockPrice);
    }

    @PostMapping("/addStockPrice")
    public ResponseEntity<StockPrice> addStockPrices(@RequestBody StockPrice stockPrice) {
        return ResponseEntity
                .ok(stockPriceService.addStockPrice(stockPrice));
    }
}
