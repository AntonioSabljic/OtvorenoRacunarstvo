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

}
