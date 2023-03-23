package com.example.fbcasejava01energiebedrijftimbanh.models;

import java.time.LocalDate;

public class Energie {
    private double tarief;
    private LocalDate beginDatum;
    private LocalDate eindDatum;

    public Energie(double tarief, LocalDate beginDatum, LocalDate eindDatum) {
        this.tarief = tarief;
        this.beginDatum = beginDatum;
        this.eindDatum = eindDatum;
    }

    public Energie() {
    }

    @Override
    public String toString() {
        return "Energie{" +
                "tarief=" + tarief +
                ", beginDatum=" + beginDatum +
                ", eindDatum=" + eindDatum +
                '}';
    }

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
