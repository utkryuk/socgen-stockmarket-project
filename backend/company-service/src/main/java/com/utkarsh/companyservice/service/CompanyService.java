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
        return null;
    }

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company updateCompany(Company company, int id) {
        Optional<Company> updatedCompany = companyRepository.findById(id);
        if (updatedCompany.isPresent()) {
            company.setId(id);
            return companyRepository.save(company);
        }
        return null;
    }

    public boolean deleteCompanyById(int id) {
        Optional<Company> deleteCompany = companyRepository.findById(id);
        if (deleteCompany.isPresent()) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

//    public List<Company> getCompaniesByExchange(int id) {
//        return companyRepository.findCompaniesByExchangeId(id);
//    }

    public List<Company> getCompaniesByPattern(String pattern) {
        return companyRepository.findByNameContainingIgnoreCase(pattern);
    }

}
