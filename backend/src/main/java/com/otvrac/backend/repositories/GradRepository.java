package com.otvrac.backend.repositories;

import com.otvrac.backend.domain.Grad;
import com.otvrac.backend.domain.Zupanija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface GradRepository extends JpaRepository<Grad, String> {
    @Query("SELECT g FROM Grad g WHERE g.naziv_zupanije = :naziv")
    List<Grad> findGradByNazivZup(@Param("naziv")String naziv);

    @Query("SELECT g FROM Grad g WHERE g.nazivG = :naziv")
    Grad findGradByNaziv(@Param("naziv")String naziv);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Grad (nazivG,povrsinag_km2,broj_stanovnika_grada,naziv_zupanije) VALUES (:nazivG, :povrsinag_km2, :broj_stanovnika_grada, :naziv_zupanije)",nativeQuery = true)
    Integer insertGrad(@Param("nazivG") String nazivG, @Param("povrsinag_km2") Integer povrsinag_km2, @Param("broj_stanovnika_grada") Integer broj_stanovnika_grada, @Param("naziv_zupanije") String naziv_zupanije);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Grad g WHERE g.nazivG = :nazivG",nativeQuery = true)
    Integer removeGradByNaziv(@Param("nazivG") String nazivG);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Grad SET povrsinag_km2 = :povrsinag_km2, broj_stanovnika_grada = :broj_stanovnika_grada, naziv_zupanije = :naziv_zupanije WHERE nazivg = :nazivG", nativeQuery = true)
    Integer updateGradByNaziv(@Param("nazivG") String nazivG, @Param("povrsinag_km2") Integer povrsinag_km2, @Param("broj_stanovnika_grada") Integer broj_stanovnika_grada, @Param("naziv_zupanije") String naziv_zupanije);
}
