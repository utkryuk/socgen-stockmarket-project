package com.utkarsh.sectorservice.repository;

import com.utkarsh.sectorservice.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Integer> {

    Sector findByName(String sectorName);
}
