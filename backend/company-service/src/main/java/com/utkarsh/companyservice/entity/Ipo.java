package com.utkarsh.companyservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ipo")
public class Ipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    private Company company;

    @OneToOne
    private Exchange exchange;

    private double price;
    private int totalShares;
    private Timestamp openDateTime;
    private String remarks;
}
