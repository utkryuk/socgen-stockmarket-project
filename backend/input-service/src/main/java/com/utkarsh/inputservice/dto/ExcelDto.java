package com.utkarsh.inputservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelDto {

    private int companyId;
    private int exchangeId;
    private double price;
    private Timestamp timestamp;

}
