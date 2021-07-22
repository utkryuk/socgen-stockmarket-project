package com.utkarsh.sectorservice.controller;

import com.utkarsh.sectorservice.entity.Company;
import com.utkarsh.sectorservice.entity.Sector;
import com.utkarsh.sectorservice.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sectors")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping("/")
    public ResponseEntity<List<Sector>> getAllSectors() {
        return ResponseEntity
                .ok(sectorService.getAllSectors());
    }

    @PostMapping("/")
    public ResponseEntity<Sector> addSector(@RequestBody Sector sector) {
        return ResponseEntity
                .ok(sectorService.addSector(sector));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSectorById(@PathVariable("id") int id) {
        Sector sector = sectorService.getSectorById(id);
        if (sector == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No Sector found");
        }

        return ResponseEntity
                .ok(sector);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSector(@RequestBody Sector sector, @PathVariable("id") int id) {

        Sector sectorToUpdate = sectorService.updateSector(sector, id);
        if (sectorToUpdate == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No Sector found");
        }

        return ResponseEntity
                .ok(sectorToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSector(@PathVariable("id") int id) {

        boolean isSectorDeleted = sectorService.deleteSector(id);
        if (!isSectorDeleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No Sector found");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Sector deleted successfully");
    }

    @GetMapping("/{sectorId}/companies")
    public ResponseEntity<?> getCompaniesBySector(@PathVariable("sectorId") int id) {

        List<Company> companiesList = sectorService.getCompaniesBySector(id);
        if (companiesList == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No Companies found in sector");
        }

        return ResponseEntity
                .ok(companiesList);
    }

    @PostMapping("/company/{sectorName}")
    public ResponseEntity<?> addCompanyToSector(@RequestBody Company company,
                                                @PathVariable("sectorName") String sectorName) {

        Sector sector = sectorService.addCompanyToSector(sectorName, company);
        if (sector == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No Sector found with this sector-name");
        }

        return ResponseEntity
                .ok(sector);
    }
}
