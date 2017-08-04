package com.karoljanowski.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Created by Karol Janowski on 2017-08-04.
 */
@Entity
public class Pracownik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPracownika;
    private String imie;
    private String nazwisko;
    private String stanowisko;
    private BigDecimal pensja;
    private Date dataZatrudnienia;

    @OneToMany(mappedBy ="kierownik", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Projekt> projektList;

    @OneToMany(mappedBy ="pracownik", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Uczestnik> uczestnikList;

    public List<Uczestnik> getUczestnikList() {
        return uczestnikList;
    }

    public void setUczestnikList(List<Uczestnik> uczestnikList) {
        this.uczestnikList = uczestnikList;
    }

    public List<Projekt> getProjektList() {
        return projektList;
    }

    public void setProjektList(List<Projekt> projektList) {
        this.projektList = projektList;
    }

    public int getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(int idPracownika) {
        this.idPracownika = idPracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public BigDecimal getPensja() {
        return pensja;
    }

    public void setPensja(BigDecimal pensja) {
        this.pensja = pensja;
    }

    public Date getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(Date dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }
}
