package com.utkarsh.companyservice.service;

import com.utkarsh.companyservice.entity.Stock;
import com.utkarsh.companyservice.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock getStockById(int id) {
        Optional<Stock> stock = stockRepository.findById(id);
        if (stock.isPresent()) {
            return stock.get();
        }
        return null;
    }

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

}
