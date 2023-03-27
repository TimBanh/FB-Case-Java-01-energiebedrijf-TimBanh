package com.example.fbcasejava01energiebedrijftimbanh.models;

public class Klant {
    // attributen van de klant klasse.
    private int klantnummer;
    private String voornaam;
    private String achternaam;
    private double jaVoorschot;
    // constructors om Klant objecten te maken.
    public Klant(int klantnummer, String voornaam, String achternaam, double jaOverschot) {
        this.klantnummer = klantnummer;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.jaVoorschot = jaOverschot;
    }

    public Klant(int klantnummer) {
        this.klantnummer = klantnummer;
    }
    // Getters en Setter van de attributen om ze op te halen of aan te passen.
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

    // toString functie om zichtbaar te maken wat er in de Klant objecten zit.
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


