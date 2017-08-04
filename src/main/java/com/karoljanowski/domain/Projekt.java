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
public class Projekt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProjektu;
    private String nazwa;
    private Date dataRozpoczecia;
    private Date dataZakonczenia;
    private BigDecimal koszt;

    @Column(columnDefinition = "text")
    private String opis;

    private int procentWykonania;

    @ManyToOne
    @JoinColumn(name = "kierownik")
    private Pracownik kierownik;

    @OneToMany(mappedBy ="projekt", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Uczestnik> uczestnikList;

    public List<Uczestnik> getUczestnikList() {
        return uczestnikList;
    }

    public void setUczestnikList(List<Uczestnik> uczestnikList) {
        this.uczestnikList = uczestnikList;
    }


    public int getIdProjektu() {
        return idProjektu;
    }

    public void setIdProjektu(int idProjektu) {
        this.idProjektu = idProjektu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Date getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public void setDataRozpoczecia(Date dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public Date getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(Date dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public BigDecimal getKoszt() {
        return koszt;
    }

    public void setKoszt(BigDecimal koszt) {
        this.koszt = koszt;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getProcentWykonania() {
        return procentWykonania;
    }

    public void setProcentWykonania(int procentWykonania) {
        this.procentWykonania = procentWykonania;
    }

    public Pracownik getKierownik() {
        return kierownik;
    }

    public void setKierownik(Pracownik kierownik) {
        this.kierownik = kierownik;
    }
}
