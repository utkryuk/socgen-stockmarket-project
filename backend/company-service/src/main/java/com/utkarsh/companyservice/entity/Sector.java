package com.utkarsh.companyservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "sector", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Company> companies;

}
