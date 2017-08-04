package com.karoljanowski.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Karol Janowski on 2017-08-04.
 */
@Entity
public class Uczestnik implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUczestnictwa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPracownika" )
    private Pracownik pracownik;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProjektu")
    private Projekt projekt;

    private String funkcja;
    private BigDecimal premia;
    private int ocena;

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public Projekt getProjekt() {
        return projekt;
    }

    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }

    public String getFunkcja() {
        return funkcja;
    }

    public void setFunkcja(String funkcja) {
        this.funkcja = funkcja;
    }

    public BigDecimal getPremia() {
        return premia;
    }

    public void setPremia(BigDecimal premia) {
        this.premia = premia;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
}
