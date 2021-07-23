package com.utkarsh.companyservice.service;

import com.utkarsh.companyservice.dto.ExcelDto;
import com.utkarsh.companyservice.entity.StockPrice;
import com.utkarsh.companyservice.repository.StockPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockPriceService {

    @Autowired
    private StockPriceRepository stockPriceRepository;

    public List<StockPrice> getAllStockPrices() {
        return stockPriceRepository.findAll();
    }

    public List<StockPrice> getAllStockPricesInTimePeriod(int companyId,
                                                          int exchangeId,
                                                          String fromTime,
                                                          String toTime) {

        return stockPriceRepository.
                getAllStockPricesInTimePeriod(companyId, exchangeId, fromTime, toTime);
    }

    public StockPrice getStockPriceById(int id) {
        Optional<StockPrice> stockPrice = stockPriceRepository.findById(id);
        if (stockPrice.isPresent()) {
            stockPrice.get();
        }
        return null;
    }

    public List<ExcelDto> addStockPrice(List<ExcelDto> excelDto) {
        List<ExcelDto> insertedData = new ArrayList<ExcelDto>();
        for (ExcelDto record: excelDto) {
            insertedData
                    .add(stockPriceRepository
                        .addStockPrice(
                                record.getExchangeId(),
                                record.getCompanyId(),
                                record.getPrice(),
                                record.getTimestamp()));
        }
        return insertedData;
    }

}
