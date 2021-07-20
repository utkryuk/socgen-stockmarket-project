package com.utkarsh.exchangeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stockExchange")
public class Exchange {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String brief;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private String remarks;

}
