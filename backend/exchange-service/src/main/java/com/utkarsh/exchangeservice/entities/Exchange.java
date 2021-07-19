package com.utkarsh.exchangeservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "stockExchange")
public class Exchange {

    @Id
    @GeneratedValue
    public int id;

    public String name;
    public String brief;
    public Address address;
    public String remarks;

}
