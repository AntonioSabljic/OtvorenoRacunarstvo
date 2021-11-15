package com.otvrac.backend.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Grad {
    @Id
    private String nazivG;
    private Integer povrsinag_km2;
    private Integer broj_stanovnika_grada;
    private String naziv_zupanije;

    public Grad() {
    }

    public Grad(String nazivG,
                Integer povrsinag_km2,
                Integer broj_stanovnika_grada,
                String naziv_zupanije) {
        this.nazivG = nazivG;
        this.povrsinag_km2 = povrsinag_km2;
        this.broj_stanovnika_grada = broj_stanovnika_grada;
        this.naziv_zupanije = naziv_zupanije;
    }

    public String getNazivG() {
        return nazivG;
    }

    public void setNazivG(String nazivG) {
        this.nazivG = nazivG;
    }

    public Integer getPovrsinag_km2() {
        return povrsinag_km2;
    }

    public void setPovrsinag_km2(Integer povrsinag_km2) {
        this.povrsinag_km2 = povrsinag_km2;
    }

    public Integer getBroj_stanovnika_grada() {
        return broj_stanovnika_grada;
    }

    public void setBroj_stanovnika_grada(Integer broj_stanovnika_grada) {
        this.broj_stanovnika_grada = broj_stanovnika_grada;
    }

    public String getNaziv_zupanije() {
        return naziv_zupanije;
    }

    public void setNaziv_zupanije(String naziv_zupanije) {
        this.naziv_zupanije = naziv_zupanije;
    }

    @Override
    public String toString() {
        return "Grad{" +
                "nazivG='" + nazivG + '\'' +
                ", povrsinag_km2=" + povrsinag_km2 +
                ", broj_stanovnika_grada=" + broj_stanovnika_grada +
                ", naziv_zupanije='" + naziv_zupanije + '\'' +
                '}';
    }
}
