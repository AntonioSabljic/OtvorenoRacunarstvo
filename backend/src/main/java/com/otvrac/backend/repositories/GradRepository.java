package com.otvrac.backend.repositories;

import com.otvrac.backend.domain.Grad;
import com.otvrac.backend.domain.Zupanija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradRepository extends JpaRepository<Grad, String> {
    @Query("SELECT g FROM Grad g WHERE g.naziv_zupanije = ?1")
    List<Grad> findGradByNazivZup(String naziv);
}
