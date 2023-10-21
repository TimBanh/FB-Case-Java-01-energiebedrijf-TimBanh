package com.example.fbcasejava01energiebedrijftimbanh.models;

import java.time.LocalDate;
import java.util.Date;

public class Energie {
    // attributen van de Energie klasse.
    private double tarief;
    private LocalDate beginDatum;
    private LocalDate eindDatum;
    // constructors om Energie objecten te maken.
    public Energie(double tarief, LocalDate beginDatum, LocalDate eindDatum) {
        this.tarief = tarief;
        this.beginDatum = beginDatum;
        this.eindDatum = eindDatum;
    }

    public Energie() {
    }
    // toString functie om zichtbaar te maken wat er in de Energie objecten zit.
    @Override
    public String toString() {
        return "Energie{" +
                "tarief=" + tarief +
                ", beginDatum=" + beginDatum +
                ", eindDatum=" + eindDatum +
                '}';
    }
    // Getters en Setter van de attributen om ze op te halen of aan te passen.

    public double getTarief() {
        return tarief;
    }

    public void setTarief(double tarief) {
        this.tarief = tarief;
    }

    public LocalDate getBeginDatum() {
        return beginDatum;
    }

    public void setBeginDatum(LocalDate beginDatum) {
        this.beginDatum = beginDatum;
    }

    public LocalDate getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(LocalDate eindDatum) {
        this.eindDatum = eindDatum;
    }
}
