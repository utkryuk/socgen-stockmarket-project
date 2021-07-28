package com.utkarsh.companyservice.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private long turnover;
    private String ceo;
    private String boardOfDirectors;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    @JsonBackReference
    private Sector sector;

    private String about;
}
