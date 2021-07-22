package com.utkarsh.companyservice.controller;

import com.utkarsh.companyservice.entity.Ipo;
import com.utkarsh.companyservice.service.IpoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class IpoController {

    @Autowired
    private IpoService ipoService;

    @GetMapping("/ipo")
    public ResponseEntity<List<Ipo>> getAllIpos() {
        return ResponseEntity
                .ok(ipoService.getAllIpos());
    }

    @GetMapping("/ipo/{id}")
    public ResponseEntity<?> getIpoById(@PathVariable("id") int id) {
        Ipo ipo = ipoService.getIpoById(id);
        if (ipo == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No Ipo found");
        }

        return ResponseEntity
                .ok(ipo);
    }

    @PostMapping("/ipo")
    public ResponseEntity<Ipo> addIpo(@RequestBody Ipo ipo) {
        return ResponseEntity
                .ok(ipoService.addIpo(ipo));
    }

    @PutMapping("/ipo/{id}")
    public ResponseEntity<?> updateIpo(@RequestBody Ipo ipo, @PathVariable(value = "id") int id) {

        Ipo updatedIpo = ipoService.updateIpo(id, ipo);
        if (updatedIpo == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No Ipo Found");
        }

        return ResponseEntity
                .ok(updatedIpo);
    }

    @DeleteMapping("/ipo/{id}")
    public ResponseEntity<?> deleteIpo(@PathVariable(value = "id") int id) {

        boolean isDeleted = ipoService.deleteIpo(id);
        if (!isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No Ipo found");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Ipo deleted successfully");
    }

    @GetMapping("/ipo/company/{companyId}")
    public ResponseEntity<Ipo> getIpoByCompanyId(@PathVariable(value = "companyId") int companyId) {

        Ipo ipo = ipoService.getIpoByCompanyId(companyId);
        return ResponseEntity
                .ok(ipo);
    }
}
