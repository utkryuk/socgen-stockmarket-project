package com.utkarsh.companyservice.repository;
import com.utkarsh.companyservice.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

//    @Query(value = "select * from company where id in ", nativeQuery = true)
//    List<Company> findCompaniesByExchangeId(@Param("exchangeId") int id);
//
    List<Company> findByNameContainingIgnoreCase(String pattern);
}