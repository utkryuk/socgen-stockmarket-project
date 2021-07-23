package com.utkarsh.inputservice.controller;

import com.utkarsh.inputservice.dto.ExcelDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/input")
public class ExcelController {

    @PostMapping("/stocks")
    public ResponseEntity<?> addStockPrice(@RequestBody List<ExcelDto> excelDtos) {

        String POST_REQUEST_URL = "http://localhost:8001/companies/stockPrice";
        RestTemplate restTemplate = new RestTemplate();

        ArrayList<?> addedExcelDtos = restTemplate
                .postForEntity(POST_REQUEST_URL, excelDtos, ArrayList.class)
                .getBody();

        return ResponseEntity
                .ok(excelDtos);
    }
}
