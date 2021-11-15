package com.otvrac.backend.repositories;

import com.otvrac.backend.domain.Zupanija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZupanijaRepository extends JpaRepository<Zupanija, String> {
    @Query("SELECT z FROM Zupanija z WHERE z.naziv = ?1")
    Optional<Zupanija> findZupanijaByNaziv(String naziv);

}
