package com.utkarsh.companyservice.service;

import com.utkarsh.companyservice.entity.Company;
import com.utkarsh.companyservice.entity.Ipo;
import com.utkarsh.companyservice.repository.IpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IpoService {

    @Autowired
    private IpoRepository ipoRepository;

    public List<Ipo> getAllIpos() {
        return ipoRepository.findAll();
    }

    public Ipo getIpoById(int id) {
        Optional<Ipo> ipo = ipoRepository.findById(id);
        if (ipo.isPresent()) {
            return ipo.get();
        }
        return null;
    }

    public Ipo addIpo(Ipo ipo) {
        return ipoRepository.save(ipo);
    }

    public Ipo updateIpo(int id, Ipo ipo) {
        Optional<Ipo> updatedIpo = ipoRepository.findById(id);
        if (updatedIpo.isPresent()) {
            ipo.setId(id);
            return ipoRepository.save(ipo);
        }
        return null;
    }

    public boolean deleteIpo(int id) {
        Optional<Ipo> ipo = ipoRepository.findById(id);
        if (ipo.isPresent()) {
            ipoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Ipo getIpoByCompanyId(int companyId) {
        return ipoRepository.findByCompanyId(companyId);
    }
}
