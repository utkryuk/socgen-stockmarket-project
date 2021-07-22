package com.utkarsh.companyservice.repository;

import com.utkarsh.companyservice.entity.Ipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpoRepository extends JpaRepository<Ipo, Integer> {

    Ipo findByCompanyId(int companyId);
}
