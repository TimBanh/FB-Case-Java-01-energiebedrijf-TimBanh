package com.example.fbcasejava01energiebedrijftimbanh.models;

import java.time.LocalDate;

public class Verbruik {
    private double stroomPerkwh;
    private double gasPerM3;
    private LocalDate begindatum;
    private LocalDate eindDatum;

    public Verbruik(double stroomPerkwh, double gasPerM3, LocalDate begindatum, LocalDate eindDatum) {
        this.stroomPerkwh = stroomPerkwh;
        this.gasPerM3 = gasPerM3;
        this.begindatum = begindatum;
        this.eindDatum = eindDatum;
    }

    public Verbruik() {
    }

    public double getStroomPerkwh() {
        return stroomPerkwh;
    }

    public void setStroomPerkwh(double stroomPerkwh) {
        this.stroomPerkwh = stroomPerkwh;
    }

    public double getGasPerM3() {
        return gasPerM3;
    }

    public void setGasPerM3(double gasPerM3) {
        this.gasPerM3 = gasPerM3;
    }

    public LocalDate getBegindatum() {
        return begindatum;
    }

    public void setBegindatum(LocalDate begindatum) {
        this.begindatum = begindatum;
    }

    public LocalDate getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(LocalDate eindDatum) {
        this.eindDatum = eindDatum;
    }
}
