package com.otvrac.backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.escalon.hypermedia.hydra.mapping.ContextProvider;
import de.escalon.hypermedia.hydra.mapping.Expose;
import de.escalon.hypermedia.hydra.mapping.Vocab;

import javax.persistence.*;

@Entity
@Table
@Vocab("https://schema.org/State")
@Expose("state")
public class Zupanija {
    @Id
    private String naziv;
    private Integer povrsina_km2;
    private Integer broj_stanovnika;
    private String sjediste;
    private Integer broj_gradova;
    private Integer broj_opcina;
    private String zupan;
    private Float gustoca_stanovnistva_pokm2;
    private Integer broj_clanova_u_skupstini;
    private String granici_sa_morem;

    public Zupanija() {

    }

    public Zupanija(String naziv,
                    Integer povrsina_km2,
                    Integer broj_stanovnika,
                    String sjediste,
                    Integer broj_gradova,
                    Integer broj_opcina,
                    String zupan,
                    Float gustoca_stanovnistva_pokm2,
                    Integer broj_clanova_u_skupstini,
                    String granici_sa_morem) {
        this.naziv = naziv;
        this.povrsina_km2 = povrsina_km2;
        this.broj_stanovnika = broj_stanovnika;
        this.sjediste = sjediste;
        this.broj_gradova = broj_gradova;
        this.broj_opcina = broj_opcina;
        this.zupan = zupan;
        this.gustoca_stanovnistva_pokm2 = gustoca_stanovnistva_pokm2;
        this.broj_clanova_u_skupstini = broj_clanova_u_skupstini;
        this.granici_sa_morem = granici_sa_morem;
    }
    @Expose("name")
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getPovrsina_km2() {
        return povrsina_km2;
    }

    public void setPovrsina_km2(Integer povrsina_km2) {
        this.povrsina_km2 = povrsina_km2;
    }

    public Integer getBroj_stanovnika() {
        return broj_stanovnika;
    }

    public void setBroj_stanovnika(Integer broj_stanovnika) {
        this.broj_stanovnika = broj_stanovnika;
    }

    public String getSjediste() {
        return sjediste;
    }

    public void setSjediste(String sjediste) {
        this.sjediste = sjediste;
    }

    public Integer getBroj_gradova() {
        return broj_gradova;
    }

    public void setBroj_gradova(Integer broj_gradova) {
        this.broj_gradova = broj_gradova;
    }

    public Integer getBroj_opcina() {
        return broj_opcina;
    }

    public void setBroj_opcina(Integer broj_opcina) {
        this.broj_opcina = broj_opcina;
    }

    public String getZupan() {
        return zupan;
    }

    public void setZupan(String zupan) {
        this.zupan = zupan;
    }

    public Float getGustoca_stanovnistva_pokm2() {
        return gustoca_stanovnistva_pokm2;
    }

    public void setGustoca_stanovnistva_pokm2(Float gustoca_stanovnistva_pokm2) {
        this.gustoca_stanovnistva_pokm2 = gustoca_stanovnistva_pokm2;
    }

    public Integer getBroj_clanova_u_skupstini() {
        return broj_clanova_u_skupstini;
    }

    public void setBroj_clanova_u_skupstini(Integer broj_clanova_u_skupstini) {
        this.broj_clanova_u_skupstini = broj_clanova_u_skupstini;
    }

    public String getGranici_sa_morem() {
        return granici_sa_morem;
    }

    public void setGranici_sa_morem(String granici_sa_morem) {
        this.granici_sa_morem = granici_sa_morem;
    }

    @Override
    public String toString() {
        return "Zupanija{" +
                "naziv='" + naziv + '\'' +
                ", povrsina_km2=" + povrsina_km2 +
                ", broj_stanovnika=" + broj_stanovnika +
                ", sjediste='" + sjediste + '\'' +
                ", broj_gradova=" + broj_gradova +
                ", broj_opcina=" + broj_opcina +
                ", zupan='" + zupan + '\'' +
                ", gustoca_stanovnistva_pokm2=" + gustoca_stanovnistva_pokm2 +
                ", broj_clanova_u_skupstini=" + broj_clanova_u_skupstini +
                ", granici_sa_morem='" + granici_sa_morem + '\'' +
                '}';
    }
}
