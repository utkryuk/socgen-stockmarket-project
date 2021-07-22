package com.utkarsh.companyservice.controller;

import com.utkarsh.companyservice.entity.Company;
import com.utkarsh.companyservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity
                .ok(companyService.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity getCompanyById(@PathVariable(value = "id") int id) {
        Company company = companyService.getCompanyById(id);
        if (company == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No Company found");
        }

        return ResponseEntity
                .ok(company);
    }

    @PostMapping("")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.addCompany(company));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCompany(@RequestBody Company company, @PathVariable(value = "id") int id) {
        Company updatedCompany = companyService.updateCompany(company, id);
        if (updatedCompany == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No Company found");
        }
        return ResponseEntity
                .ok(updatedCompany);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable(value = "id") int id) {
        boolean isCompanyDeleted = companyService.deleteCompanyById(id);
        if (!isCompanyDeleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No Company found");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Company Deleted Successfully");
    }

    @GetMapping("/companyByExchange/{exchangeId}")
    public ResponseEntity<List<Company>> getCompaniesByExchange(@PathVariable(value = "exchangeId") int exchangeId) {
        return ResponseEntity
                .ok(companyService.getCompaniesByExchange(exchangeId));
    }

    @GetMapping("/companyByPattern/{pattern}")
    public ResponseEntity<List<Company>> getCompaniesByPattern(@PathVariable(value = "pattern") String pattern) {
        return ResponseEntity
                .ok(companyService.getCompaniesByPattern(pattern));
    }
}
