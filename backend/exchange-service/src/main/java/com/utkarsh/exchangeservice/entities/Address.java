package com.utkarsh.exchangeservice.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String street;
    public String city;
    public String country;
    public int zip;

}
