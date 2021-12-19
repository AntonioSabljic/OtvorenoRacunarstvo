package com.otvrac.backend.services;

import com.otvrac.backend.domain.Grad;
import com.otvrac.backend.domain.Zupanija;
import com.otvrac.backend.repositories.GradRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradService {
    private final GradRepository gradRepository;
    @Autowired
    public GradService(GradRepository gradRepository) { this.gradRepository = gradRepository; }

    public List<Grad> getAllGradForZupanija(String zupanija) {
        List<Grad> allGrad = gradRepository.findGradByNazivZup(zupanija); //valjda vraca sve zupanije
        return allGrad;
    }

    public List<Grad> getAllGrad() {
        List<Grad> allGrad = gradRepository.findAll();
        return allGrad;
    }

    public Grad getGradByName(String naziv) {
        return gradRepository.findGradByNaziv(naziv);
    }

    public boolean addGrad(Grad grad) {
        Integer flag;
        flag = gradRepository.insertGrad(grad.getNazivG(), grad.getPovrsinag_km2(), grad.getBroj_stanovnika_grada(), grad.getNaziv_zupanije());
        if(flag != 0) return true;
        return false;
    }
    public boolean removeGrad(String nazivG) {
        Integer flag = gradRepository.removeGradByNaziv(nazivG);
        if(flag != 0) return true;
        return false;
    }

    public boolean updateGradByName(Grad grad, String name) {
        Integer flag = gradRepository.updateGradByNaziv(name, grad.getPovrsinag_km2(), grad.getBroj_stanovnika_grada(), grad.getNaziv_zupanije());
        if(flag != 0) return true;
        return false;
    }

}
