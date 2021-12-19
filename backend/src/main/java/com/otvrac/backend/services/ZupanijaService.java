package com.otvrac.backend.services;

import com.otvrac.backend.domain.Zupanija;
import com.otvrac.backend.repositories.ZupanijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ZupanijaService {
    private final ZupanijaRepository zupanijaRepository;
    @Autowired
    public ZupanijaService(ZupanijaRepository zupanijaRepository) { this.zupanijaRepository = zupanijaRepository; }

    public Zupanija getZupanijaByName(String name) {
        Zupanija zup = zupanijaRepository.findZupanijaByNaziv(name);

        if(zup != null) {
            return zup;
        }
        else {
            return null;
        }
    }

    public List<Zupanija> getAllZupanija() {
        List<Zupanija> allZupanija = zupanijaRepository.getAllZupanija();
        return allZupanija;
    }
}
