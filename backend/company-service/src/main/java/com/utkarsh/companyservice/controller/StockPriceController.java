package com.utkarsh.companyservice.controller;

import com.utkarsh.companyservice.dto.ExcelDto;
import com.utkarsh.companyservice.entity.StockPrice;
import com.utkarsh.companyservice.service.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/stockprice")
public class StockPriceController {

    @Autowired
    private StockPriceService stockPriceService;

    @GetMapping("")
    public ResponseEntity<List<StockPrice>> getAllStockPrices() {
        return ResponseEntity
                .ok(stockPriceService.getAllStockPrices());
    }

    @GetMapping("/{id}")
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

    @GetMapping("/companyId/{companyId}/exchangeId/{exchangeId}/{fromTime}/{toTime}")
    public ResponseEntity<List<StockPrice>> getAllStockPriceInTimePeriod(
            @PathVariable("companyId") int companyId,
            @PathVariable("exchangeId") int exchangeId,
            @PathVariable("fromTime") String fromTime,
            @PathVariable("toTime") String toTime) {

        return ResponseEntity
                .ok(stockPriceService
                        .getAllStockPricesInTimePeriod(companyId, exchangeId, fromTime, toTime));
    }

    @PostMapping("")
    public ResponseEntity<List<ExcelDto>> addStockPrices(@RequestBody List<ExcelDto> excelDto) {
        return ResponseEntity
                .ok(stockPriceService.addStockPrice(excelDto));
    }
}
