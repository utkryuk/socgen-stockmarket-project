package com.utkarsh.companyservice.controller;

import com.utkarsh.companyservice.entity.Company;
import com.utkarsh.companyservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity getCompanyById(@PathVariable(value = "id") int id) {
        Company company = companyService.getCompanyById(id);
        if (company == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No Company found");
        }

        return ResponseEntity.ok(company);
    }

}