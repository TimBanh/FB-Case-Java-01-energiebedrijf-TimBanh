package com.example.fbcasejava01energiebedrijftimbanh.models;

import java.time.LocalDate;

public class Verbruik {
    // attributen van de Verbruik klasse.
    private double stroomPerkwh;
    private double gasPerM3;
    private LocalDate begindatum;
    private LocalDate eindDatum;
    // constructors om Verbruik objecten te maken.
    public Verbruik(double stroomPerkwh, double gasPerM3, LocalDate begindatum, LocalDate eindDatum) {
        this.stroomPerkwh = stroomPerkwh;
        this.gasPerM3 = gasPerM3;
        this.begindatum = begindatum;
        this.eindDatum = eindDatum;
    }

    public Verbruik() {
    }
    // Getters en Setter van de attributen om ze op te halen of aan te passen.
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
    // toString functie om zichtbaar te maken wat er in de Verbruik objecten zit.
    @Override
    public String toString() {
        return "Verbruik{" +
                "stroomPerkwh=" + stroomPerkwh +
                ", gasPerM3=" + gasPerM3 +
                ", begindatum=" + begindatum +
                ", eindDatum=" + eindDatum +
                '}';
    }
}
