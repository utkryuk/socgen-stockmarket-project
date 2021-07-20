package com.utkarsh.companyservice.service;

import com.utkarsh.companyservice.entity.Company;
import com.utkarsh.companyservice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(int id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            return company.get();
        }
        else {
            return null;
        }
    }

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }
}
