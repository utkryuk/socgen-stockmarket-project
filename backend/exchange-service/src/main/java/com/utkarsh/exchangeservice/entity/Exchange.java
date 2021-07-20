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
    public int id;

    public String name;
    public String brief;

    @OneToOne(cascade = CascadeType.ALL)
    public Address address;

    public String remarks;

}
