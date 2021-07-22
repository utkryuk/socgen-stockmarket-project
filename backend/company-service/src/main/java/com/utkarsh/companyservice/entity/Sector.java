package com.utkarsh.companyservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sector")
public class Sector {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String brief;

//    @OneToMany
//    @JoinColumn(name = "company_id")
////    @JoinColumn(name = "sector_id", referencedColumnName = "id")
//    private List<Company> companies;

}
