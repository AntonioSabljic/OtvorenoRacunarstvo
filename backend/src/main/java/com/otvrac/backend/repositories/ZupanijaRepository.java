package com.otvrac.backend.repositories;

import com.otvrac.backend.domain.Zupanija;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ZupanijaRepository extends JpaRepository<Zupanija, String> {
    @Query("SELECT z FROM Zupanija z WHERE z.naziv = :naziv")
    Zupanija findZupanijaByNaziv(@Param("naziv") String naziv);

    @Query("SELECT z FROM Zupanija z")
    List<Zupanija> getAllZupanija();


}
