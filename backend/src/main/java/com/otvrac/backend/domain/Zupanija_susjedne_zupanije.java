package com.otvrac.backend.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Zupanija_susjedne_zupanije {
    private String naziv;
    @Id
    private String susjedne_zupanije;

    public Zupanija_susjedne_zupanije() {
    }

    public Zupanija_susjedne_zupanije(String naziv, String susjedne_zupanije) {
        this.naziv = naziv;
        this.susjedne_zupanije = susjedne_zupanije;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSusjedne_zupanije() {
        return susjedne_zupanije;
    }

    public void setSusjedne_zupanije(String susjedne_zupanije) {
        this.susjedne_zupanije = susjedne_zupanije;
    }

    @Override
    public String toString() {
        return "Zupanija_susjedne_zupanije{" +
                "naziv='" + naziv + '\'' +
                ", susjedne_zupanije='" + susjedne_zupanije + '\'' +
                '}';
    }
}
