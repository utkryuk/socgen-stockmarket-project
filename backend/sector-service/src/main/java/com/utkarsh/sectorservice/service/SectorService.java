package com.utkarsh.sectorservice.service;

import com.utkarsh.sectorservice.entity.Company;
import com.utkarsh.sectorservice.entity.Sector;
import com.utkarsh.sectorservice.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    public List<Sector> getAllSectors() {
        return sectorRepository.findAll();
    }

    public Sector getSectorById(int id) {
        Optional<Sector> sector = sectorRepository.findById(id);
        if (sector.isPresent()) {
            return sector.get();
        }
        return null;
    }

    public Sector addSector(Sector sector) {
        return sectorRepository.save(sector);
    }

    public Sector updateSector(Sector sector, int id) {
        Optional<Sector> sectorToUpdate = sectorRepository.findById(id);
        if (sectorToUpdate.isPresent()) {
               sector.setId(id);
               sectorRepository.save(sector);
        }
        return null;
    }

    public boolean deleteSector(int id) {
        Optional<Sector> sectorToDelete = sectorRepository.findById(id);
        if (sectorToDelete.isPresent()) {
            sectorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Company> getCompaniesBySector(int id) {
        Optional<Sector> sector = sectorRepository.findById(id);
        if (sector.isPresent()) {
            return sector
                    .get()
                    .getCompanies();
        }
        return null;
    }

    public Sector addCompanyToSector(String sectorName, Company company) {

        Sector sector = sectorRepository.findByName(sectorName);
        if (sector != null) {
            sector
                    .getCompanies()
                    .add(company);

            return sectorRepository.save(sector);
        }

        return null;
    }

}
