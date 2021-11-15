package com.otvrac.backend.repositories;

import com.otvrac.backend.domain.Grad;
import com.otvrac.backend.domain.Zupanija;
import com.otvrac.backend.domain.Zupanija_susjedne_zupanije;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Zupanija_susjedne_zupanijeRepository extends JpaRepository<Zupanija_susjedne_zupanije, String> {
    @Query("SELECT zs FROM Zupanija_susjedne_zupanije zs WHERE zs.naziv = ?1")
    List<Zupanija_susjedne_zupanije> findSusZupanijeByNaziv(String naziv);
}
