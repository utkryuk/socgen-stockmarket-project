package com.utkarsh.companyservice.service;

import com.utkarsh.companyservice.entity.StockPrice;
import com.utkarsh.companyservice.repository.StockPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockPriceService {

    @Autowired
    private StockPriceRepository stockPriceRepository;

    public List<StockPrice> getAllStockPrices() {
        return stockPriceRepository.findAll();
    }

    public StockPrice getStockPriceById(int id) {
        Optional<StockPrice> stockPrice = stockPriceRepository.findById(id);
        if (stockPrice.isPresent()) {
            stockPrice.get();
        }
        return null;
    }

    public StockPrice addStockPrice(StockPrice stockPrice) {
        return stockPriceRepository.save(stockPrice);
    }

}
