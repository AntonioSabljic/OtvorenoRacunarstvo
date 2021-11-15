package com.otvrac.backend.services;

import com.otvrac.backend.domain.Zupanija;
import com.otvrac.backend.domain.Zupanija_susjedne_zupanije;
import com.otvrac.backend.repositories.Zupanija_susjedne_zupanijeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class Zupanija_susjedne_zupanijeService {
    private final Zupanija_susjedne_zupanijeRepository zupanija_susjedne_zupanijeRepository;
    @Autowired
    public Zupanija_susjedne_zupanijeService(Zupanija_susjedne_zupanijeRepository zupanija_susjedne_zupanijeRepository) {
        this.zupanija_susjedne_zupanijeRepository = zupanija_susjedne_zupanijeRepository;
    }

    public List<Zupanija_susjedne_zupanije> getAllZupanijaSusZupanije() {
        List<Zupanija_susjedne_zupanije> zupanija_susjedne_zupanije = zupanija_susjedne_zupanijeRepository.findAll();
        return zupanija_susjedne_zupanije;
    }
    public List<Zupanija_susjedne_zupanije> getAllZupanijaSusZupanijeByZupanijaName(String zupanija) {
        List<Zupanija_susjedne_zupanije> zupanija_susjedne_zupanije = zupanija_susjedne_zupanijeRepository.findSusZupanijeByNaziv(zupanija);
        System.out.println(zupanija_susjedne_zupanije.toString());
        return zupanija_susjedne_zupanije;
    }

}
