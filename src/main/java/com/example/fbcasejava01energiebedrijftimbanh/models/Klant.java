package com.example.fbcasejava01energiebedrijftimbanh.models;

public class Klant {
    private int klantnummer;
    private String voornaam;
    private String achternaam;
    private double jaVoorschot;

    public Klant(int klantnummer, String voornaam, String achternaam, double jaOverschot) {
        this.klantnummer = klantnummer;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.jaVoorschot = jaOverschot;
    }

    public int getKlantnummer() {
        return klantnummer;
    }

    public void setKlantnummer(int klantnummer) {
        this.klantnummer = klantnummer;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public double getJaOverschot() {
        return jaVoorschot;
    }

    public void setJaOverschot(double jaOverschot) {
        this.jaVoorschot = jaOverschot;
    }

    @Override
    public String toString() {
        return "Klant{" +
                "klantnummer=" + klantnummer +
                ", voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", jaVoorschot=" + jaVoorschot +
                '}';
    }
}


